/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002.DBE250002_ImageTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenShujiiFuicchi;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.ImageinputDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * イメージ取込み（規定・規定外）のコントローラクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class ImageinputHandler {

    private final ImageinputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ImageinputHandler(ImageinputDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理を行います。
     */
    public void initialize() {
        div.getRadIchijiHanteiZumi().setSelectedKey(getInitialValueRadIchijiHanteiZumi());
        div.getRadYojitsuDoctorFuicchi().setSelectedKey(getInitialValueRadYojitsuDoctorFuicchi());
    }

    private static RString getInitialValueRadIchijiHanteiZumi() {
        RString firstValue = BusinessConfig.get(ConfigNameDBE.イメージ取込_一次判定済みの申請者_処理方法);
        return firstValue == null ? TreatmentWhenIchijiHanteiZumi.エラーとする.code() : firstValue;
    }

    private static RString getInitialValueRadYojitsuDoctorFuicchi() {
        RString firstValue = BusinessConfig.get(ConfigNameDBE.イメージ取込_依頼時と実施時での医師の不一致_処理方法);
        return firstValue == null ? TreatmentWhenShujiiFuicchi.エラーとする.code() : firstValue;
    }

    /**
     * 画面情報としてセットされている項目を元に、バッチパラメータとして生成する。
     *
     * @return バッチパラメータ
     */
    public DBE250002_ImageTorikomiParameter createBatchParameter() {
        return new DBE250002_ImageTorikomiParameter(
                div.getHdnSharedFileEntryInfo(),
                TreatmentWhenIchijiHanteiZumi.toValue(div.getRadIchijiHanteiZumi().getSelectedKey()),
                TreatmentWhenShujiiFuicchi.toValue(div.getRadYojitsuDoctorFuicchi().getSelectedKey())
        );
    }
}
