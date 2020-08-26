package com.example.sample.controller.abstruct;

import com.example.sample.common.security.Authorizable;
import com.example.sample.common.util.FunctionNameAware;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.example.sample.WebConst.MAV_ERRORS;

/**
 * 基底HTMLコントローラー
 */
@Slf4j
public abstract class AbstractHtmlController extends BaseController implements FunctionNameAware, Authorizable {

    @Override
    public boolean authorityRequired() {
        return true;
    }

    /**
     * 入力チェックエラーがある場合はtrueを返します。
     *
     * @param model
     * @return
     */
    public boolean hasErrors(Model model) {
        val errors = model.asMap().get(MAV_ERRORS);

        if (errors instanceof BeanPropertyBindingResult) {
            val br = ((BeanPropertyBindingResult) errors);

            return br.hasErrors();
        }

        return false;
    }

    /**
     * リダイレクト先に入力エラーを渡します。
     *
     * @param attributes
     * @param result
     */
    public void setFlashAttributeErrors(RedirectAttributes attributes, BindingResult result) {
        attributes.addFlashAttribute(MAV_ERRORS, result);
    }
}
