/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChosaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenChosainFuicchi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenShujiiFuicchi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenTokkiRembanChofuku;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 認定調査結果取込み（OCR）のコントローラクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiChosaKekkaTorikomiOcrHandler {

    private final NinteiChosaOCRTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiChosaKekkaTorikomiOcrHandler(NinteiChosaOCRTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 画面に表示するサーバファイルパスを取得し、テキストボックスにセットします。
     */
    public void initialize() {
        div.getRadIchijiHanteiZumi().setSelectedKey(getInitialValueRadIchijiHanteiZumi());
        div.getRadYojitsuChosainFuicchi().setSelectedKey(getInitialValueRadYojitsuChosainFuicchi());
        div.getRadTokkiRembanChofuku().setSelectedKey(getInitialValueRadTokkiRembanChofuku());
    }

    private static RString getInitialValueRadIchijiHanteiZumi() {
        RString firstValue = BusinessConfig.get(ConfigNameDBE.認定調査取込_一次判定済みの申請者_処理方法);
        return firstValue == null ? TreatmentWhenIchijiHanteiZumi.エラーとする.code() : firstValue;
    }

    private static RString getInitialValueRadYojitsuChosainFuicchi() {
        RString firstValue = BusinessConfig.get(ConfigNameDBE.認定調査取込_依頼時と実施時での調査員の不一致_処理方法);
        return firstValue == null ? TreatmentWhenShujiiFuicchi.エラーとする.code() : firstValue;
    }

    private static RString getInitialValueRadTokkiRembanChofuku() {
        RString firstValue = BusinessConfig.get(ConfigNameDBE.認定調査取込_特記事項連番_以前の取込結果との重複_処理方法);
        return firstValue == null ? TreatmentWhenShujiiFuicchi.エラーとする.code() : firstValue;
    }

    /**
     * 画面情報としてセットされている項目を元に、バッチパラメータとして生成する。
     *
     * @return バッチパラメータ
     */
    public DBE250001_NinteiChosaKekkaTorikomiParameter createBatchParameter() {
        return new DBE250001_NinteiChosaKekkaTorikomiParameter(
                div.getHdnSharedFileEntryInfo(),
                TreatmentWhenIchijiHanteiZumi.toValue(div.getRadIchijiHanteiZumi().getSelectedKey()),
                TreatmentWhenChosainFuicchi.toValue(div.getRadYojitsuChosainFuicchi().getSelectedKey()),
                TreatmentWhenTokkiRembanChofuku.toValue(div.getRadTokkiRembanChofuku().getSelectedKey())
        );
    }
}
