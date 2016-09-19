/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計画届出状況チェックリストHeaderEditorクラスです。
 *
 * @reamsid_L DBC-1960-040 wangxingpeng
 */
public class KyotakuServiceKeikakuSaBodyEditor implements IKyotakuServiceKeikakuSaEditor {

    private final KyotakuServiceKeikakuSaParam target;

    /**
     * コンストラクタです。
     *
     * @param target KyotakuServiceKeikakuSaParam
     */
    public KyotakuServiceKeikakuSaBodyEditor(KyotakuServiceKeikakuSaParam target) {
        this.target = target;
    }

    @Override
    public KyotakuServiceKeikakuSakuseiSource edit(KyotakuServiceKeikakuSakuseiSource source) {
        source.pagecnt = new RString(target.get連番());
        if (target.get計画届出状況情報リスト() != null) {
            KyotakuServiceKeikakuSaList 帳票情報 = target.get計画届出状況情報リスト();
            if (帳票情報.get宛名() != null) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(帳票情報.get宛名()).to個人();
                source.listList1_2 = 宛名.get名称().getKana().value();
                source.listList2_2 = 宛名.get名称().getName().value();
                source.listList3_1 = new RString(宛名.get生年月日().toFlexibleDate().toString());
                source.listList1_3 = 宛名.get住所().get全国住所コード().getColumnValue();
                source.listList1_4 = 宛名.get行政区画().getGyoseiku().getコード().getColumnValue();
                source.listList2_3 = 宛名.get住所().get住所();
                source.listList3_2 = 宛名.get行政区画().getGyoseiku().get名称();
            }
            if (帳票情報.get被保険者番号() != null) {
                source.listList1_1 = 帳票情報.get被保険者番号().getColumnValue();
            }
            if (帳票情報.get住民コード() != null) {
                source.listList2_1 = 帳票情報.get住民コード().getColumnValue();
            }
            if (帳票情報.get資格取得日() != null) {
                source.listList1_5 = new RString(帳票情報.get資格取得日().toString());
            }
            if (帳票情報.get資格喪失日() != null) {
                source.listList2_4 = new RString(帳票情報.get資格喪失日().toString());
            }
            source.listList3_3 = 帳票情報.get喪失事由();
            if (帳票情報.get受給申請日() != null) {
                source.listList1_6 = new RString(帳票情報.get受給申請日().toString());
            }
            source.listList1_7 = 帳票情報.get申請事由();
            source.listList1_8 = 帳票情報.get要介護度();
            if (帳票情報.get認定有効開始日() != null) {
                source.listList2_5 = new RString(帳票情報.get認定有効開始日().toString());
            }
            if (帳票情報.get認定有効終了日() != null) {
                source.listList2_6 = new RString(帳票情報.get認定有効終了日().toString());
            }
            if (帳票情報.get認定日().toString() != null) {
                source.listList2_7 = new RString(帳票情報.get認定日().toString());
            }
            source.listList3_4 = 帳票情報.get現在の申請状況();
            if (帳票情報.get計画届出日() != null) {
                source.listList1_9 = new RString(帳票情報.get計画届出日().toString());
            }
            if (帳票情報.get計画適用開始日() != null) {
                source.listList1_10 = new RString(帳票情報.get計画適用開始日().toString());
            }
            if (帳票情報.get計画適用終了日() != null) {
                source.listList1_11 = new RString(帳票情報.get計画適用終了日().toString());
            }
            if (帳票情報.get事業者番号() != null) {
                source.listList2_8 = 帳票情報.get事業者番号().getColumnValue();
            }
            if (帳票情報.get電話番号() != null) {
                source.listList2_9 = 帳票情報.get電話番号().getColumnValue();
            }
            if (帳票情報.get変更年月日() != null) {
                source.listList2_10 = new RString(帳票情報.get変更年月日().toString());
            }
            source.listList3_5 = 帳票情報.get事業者名称();
            source.listList1_12 = 帳票情報.get備考1();
            source.listList3_6 = 帳票情報.get備考2();
        }
        return source;

    }

}
