/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigodoguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigodoGuide.YokaigodoGuide.YokaigodoGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigodoGuide.YokaigodoGuide.dgYokaigodoGuide_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 要介護度ガイドの取得するクラスです。
 */
public class YokaigodoGuideHandler {

    private final YokaigodoGuideDiv godoDiv;
    private final int 桁数_6 = 6;

    /**
     * コンストラクタです。
     *
     * @param godoDiv YokaigodoGuideDiv
     */
    public YokaigodoGuideHandler(YokaigodoGuideDiv godoDiv) {
        this.godoDiv = godoDiv;
    }

    /**
     * 要介護度ガイドを検索する。
     */
    public void initialize() {
        List<dgYokaigodoGuide_Row> dgYokaigodoGuideList = new ArrayList<>();
        FlexibleDate kizyuniti = new FlexibleDate(godoDiv.getKijunYMD().substring(0, 桁数_6));
        if (new FlexibleDate("200004").isBefore(kizyuniti)
                && kizyuniti.isBefore(new FlexibleDate("200203"))) {
            for (YokaigoJotaiKubun99 yokaigoJotaiKubun99 : YokaigoJotaiKubun99.values()) {
                dgYokaigodoGuide_Row dgJigyoshaItiran = new dgYokaigodoGuide_Row();
                dgJigyoshaItiran.setCode(yokaigoJotaiKubun99.getコード());
                dgJigyoshaItiran.setMeisho(yokaigoJotaiKubun99.get名称());
                dgYokaigodoGuideList.add(dgJigyoshaItiran);
            }
        }
        if (new FlexibleDate("200204").isBefore(kizyuniti)
                && kizyuniti.isBefore(new FlexibleDate("200603"))) {
            for (YokaigoJotaiKubun02 yokaigoJotaiKubun02 : YokaigoJotaiKubun02.values()) {
                dgYokaigodoGuide_Row dgJigyoshaItiran = new dgYokaigodoGuide_Row();
                dgJigyoshaItiran.setCode(yokaigoJotaiKubun02.getコード());
                dgJigyoshaItiran.setMeisho(yokaigoJotaiKubun02.get名称());
                dgYokaigodoGuideList.add(dgJigyoshaItiran);
            }
        }
        if (new FlexibleDate("200604").isBefore(kizyuniti)
                && kizyuniti.isBefore(new FlexibleDate("200903"))) {
            for (YokaigoJotaiKubun06 yokaigoJotaiKubun06 : YokaigoJotaiKubun06.values()) {
                dgYokaigodoGuide_Row dgJigyoshaItiran = new dgYokaigodoGuide_Row();
                dgJigyoshaItiran.setCode(yokaigoJotaiKubun06.getコード());
                dgJigyoshaItiran.setMeisho(yokaigoJotaiKubun06.get名称());
                dgYokaigodoGuideList.add(dgJigyoshaItiran);
            }
        }
        if (new FlexibleDate("200904").isBefore(kizyuniti)) {
            for (YokaigoJotaiKubun09 yokaigoJotaiKubun09 : YokaigoJotaiKubun09.values()) {
                dgYokaigodoGuide_Row dgJigyoshaItiran = new dgYokaigodoGuide_Row();
                dgJigyoshaItiran.setCode(yokaigoJotaiKubun09.getコード());
                dgJigyoshaItiran.setMeisho(yokaigoJotaiKubun09.get名称());
                dgYokaigodoGuideList.add(dgJigyoshaItiran);
            }
        }
        godoDiv.getDgYokaigodoGuide().setDataSource(dgYokaigodoGuideList);
    }

    /**
     * 入力チェックを行います。
     *
     * @param godoDiv YokaigodoGuideDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_btnKakuninn(YokaigodoGuideDiv godoDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        getValidationHandler(godoDiv).一覧データなしチェック(validationMessages);
        return validationMessages;
    }

    private ValidationHandler getValidationHandler(YokaigodoGuideDiv godoDiv) {
        return new ValidationHandler(godoDiv);
    }
}
