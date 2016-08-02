/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501001;

import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;

/**
 * 要介護認定申請書ボディEditorです。
 *
 * @reamsid_L DBD-1400-020 b_zhengs
 */
public class YokaigoNinteiShinseishoBodyEditor implements IYokaigoNinteiShinseishoEditor {

    private final ShinseiShoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定申請書の一覧Entity
     */
    public YokaigoNinteiShinseishoBodyEditor(ShinseiShoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定申請書ボディEditorです。
     *
     * @param source 要介護認定申請書Source
     * @return 要介護認定申請書Source
     */
    @Override
    public YokaigoNinteiShinseishoReportSource edit(YokaigoNinteiShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private YokaigoNinteiShinseishoReportSource bodyEdit(YokaigoNinteiShinseishoReportSource source) {
        // TODO     RSE項目名が設計書と違い
        source.ninshoshaYakushokuMei = entity.get市町村名称();
        source.hihokenshaNo1 = entity.get被保険者番号第1桁();
        source.hihokenshaNo2 = entity.get被保険者番号第2桁();
        source.hihokenshaNo3 = entity.get被保険者番号第3桁();
        source.hihokenshaNo4 = entity.get被保険者番号第4桁();
        source.hihokenshaNo5 = entity.get被保険者番号第5桁();
        source.hihokenshaNo6 = entity.get被保険者番号第6桁();
        source.hihokenshaNo7 = entity.get被保険者番号第7桁();
        source.hihokenshaNo8 = entity.get被保険者番号第8桁();
        source.hihokenshaNo9 = entity.get被保険者番号第9桁();
        source.hihokenshaNo10 = entity.get被保険者番号第10桁();
        source.birthGengoMeiji = entity.get出生元号明治();
        source.birthGengoTaisho = entity.get出生元号大正();
        source.birthGengoShowa = entity.get出生元号昭和();
        source.hihokenshaNameKana = entity.get被保険者名称カナ();
        source.birthYYYY = entity.get出生年YYYY();
        source.umareYy = entity.get生まれYY();
        source.birthMM = entity.get出生月MM();
        source.birthDD = entity.get出生日DD();
        source.hihokenshaName = entity.get被保険者名称();
        source.seibetsuMan = entity.get性別男();
        source.seibetsuWoman = entity.get性別女();
        source.telNo = entity.get電話番号();
        source.yubinNo = entity.get郵便番号();
        source.jusho = entity.get住所();
        source.yokaigoJotaiKubun1 = entity.get要介護状態区分1();
        source.yokaigoJotaiKubun2 = entity.get要介護状態区分2();
        source.yokaigoJotaiKubun3 = entity.get要介護状態区分3();
        source.yokaigoJotaiKubun4 = entity.get要介護状態区分4();
        source.yokaigoJotaiKubun5 = entity.get要介護状態区分5();
        source.yoshienJotaiKubun1 = entity.get要支援状態区分1();
        source.yoshienJotaiKubun2 = entity.get要支援状態区分2();
        source.yukoKaishiYYYY = entity.get有効開始年YYYY();
        source.yukoKaishiMM = entity.get有効開始月MM();
        source.yukoKaishiDD = entity.get有効開始日DD();
        source.yukoShuryoYYYY = entity.get有効終了年YYYY();
        source.yukoShuryoMM = entity.get有効終了月MM();
        source.yukoShuryoDD = entity.get有効終了日DD();

        return source;

    }

}
