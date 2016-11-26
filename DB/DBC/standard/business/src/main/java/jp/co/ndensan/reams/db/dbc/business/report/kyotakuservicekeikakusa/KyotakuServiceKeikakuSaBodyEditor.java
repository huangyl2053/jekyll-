/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 計画届出状況チェックリストHeaderEditorクラスです。
 *
 * @reamsid_L DBC-1960-040 wangxingpeng
 */
public class KyotakuServiceKeikakuSaBodyEditor implements IKyotakuServiceKeikakuSaEditor {

    private final KyotakuServiceKeikakuSaParam target;
    private static final RString 文_被保険者番号 = new RString("被保険者番号");
    private static final RString 記号 = new RString("：");

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
        if (target.get計画届出状況情報リスト() != null) {
            KyotakuServiceKeikakuSaList 帳票情報 = target.get計画届出状況情報リスト();
            if (帳票情報.get市町村コード() != null) {
                source.shichosonCode = 帳票情報.get市町村コード().getColumnValue();
            }
            if (帳票情報.get宛名() != null) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(帳票情報.get宛名()).to個人();
                source.listList1_2 = 宛名.get名称().getKana().value();
                source.listList2_2 = 宛名.get名称().getName().value();
                source.listList3_1 = 宛名.get生年月日().toFlexibleDate().seireki().toDateString();
                source.listList1_3 = 宛名.get住所().get全国住所コード().getColumnValue();
                source.listList1_4 = 宛名.get行政区画().getGyoseiku().getコード().getColumnValue();
                source.listList2_3 = 宛名.get住所().get住所();
                source.listList3_2 = 宛名.get行政区画().getGyoseiku().get名称();
                setBreak宛名(source, 帳票情報.get宛名());
            }

            if (帳票情報.get識別コード() != null) {
                source.listList2_1 = 帳票情報.get識別コード().getColumnValue();
            }
            if (帳票情報.get資格取得日() != null) {
                source.listList1_5 = パターン4(帳票情報.get資格取得日());
            }
            if (帳票情報.get資格喪失日() != null) {
                source.listList2_4 = パターン4(帳票情報.get資格喪失日());
            }
            source.listList3_3 = 帳票情報.get喪失事由();

            source.listList1_7 = 帳票情報.get申請事由();
            if (帳票情報.get受給申請日() != null) {
                FlexibleDate 申請日 = 帳票情報.get受給申請日();
                source.listList1_6 = パターン4(申請日);
                source.listList3_4 = パターン4(申請日).concat(記号).concat(帳票情報.get申請事由());
            }

            source.listList1_8 = 帳票情報.get要介護度();
            if (帳票情報.get認定有効開始日() != null) {
                source.listList2_5 = パターン4(帳票情報.get認定有効開始日());
            }
            if (帳票情報.get認定有効終了日() != null) {
                source.listList2_6 = パターン4(帳票情報.get認定有効終了日());
            }
            if (帳票情報.get認定日().toString() != null) {
                source.listList2_7 = パターン4(帳票情報.get認定日());
            }

            if (帳票情報.get計画届出日() != null) {
                source.listList1_9 = パターン4(帳票情報.get計画届出日());
            }
            if (帳票情報.get計画適用開始日() != null) {
                source.listList1_10 = パターン4(帳票情報.get計画適用開始日());
            }
            if (帳票情報.get計画適用終了日() != null) {
                source.listList1_11 = パターン4(帳票情報.get計画適用終了日());
            }
            if (帳票情報.get事業者番号() != null) {
                source.listList2_8 = 帳票情報.get事業者番号().getColumnValue();
            }
            if (帳票情報.get電話番号() != null) {
                source.listList2_9 = 帳票情報.get電話番号().getColumnValue();
            }
            if (帳票情報.get変更年月日() != null) {
                source.listList2_10 = パターン4(帳票情報.get変更年月日());
            }
            source.listList3_5 = 帳票情報.get事業者名称();
            source.listList1_12 = 帳票情報.get備考1();
            source.listList3_6 = 帳票情報.get備考2();
            editAccessLog(帳票情報, source);

        }
        source.listList1_4 = source.listList1_4 == null ? RString.EMPTY : source.listList1_4;
        source.listList2_1 = source.listList2_1 == null ? RString.EMPTY : source.listList2_1;
        source.listList3_1 = source.listList3_1 == null ? RString.EMPTY : source.listList3_1;
        source.seibetsuCode = source.seibetsuCode == null ? RString.EMPTY : source.seibetsuCode;
        source.shichosonCode = source.shichosonCode == null ? RString.EMPTY : source.shichosonCode;
        source.listList1_1 = source.listList1_1 == null ? RString.EMPTY : source.listList1_1;
        source.listList1_9 = source.listList1_9 == null ? RString.EMPTY : source.listList1_9;
        source.listList2_8 = source.listList2_8 == null ? RString.EMPTY : source.listList2_8;
        source.listList1_6 = source.listList1_6 == null ? RString.EMPTY : source.listList1_6;
        source.listList2_7 = source.listList2_7 == null ? RString.EMPTY : source.listList2_7;
        return source;

    }

    private void setBreak宛名(KyotakuServiceKeikakuSakuseiSource source, UaFt200FindShikibetsuTaishoEntity 宛名) {
        YubinNo 郵便番号 = 宛名.getYubinNo();
        source.yubinNo = 郵便番号 == null ? RString.EMPTY : 郵便番号.getYubinNo();
        ChoikiCode 町域コード = 宛名.getChoikiCode();
        source.choikiCode = 町域コード == null ? RString.EMPTY : 町域コード.getColumnValue();
        BanchiCode 番地コード1 = 宛名.getBanchiCode1();
        BanchiCode 番地コード2 = 宛名.getBanchiCode2();
        BanchiCode 番地コード3 = 宛名.getBanchiCode3();
        BanchiCode 番地コード4 = 宛名.getBanchiCode4();
        source.banchiCode1 = 番地コード1 == null ? RString.EMPTY : 番地コード1.getColumnValue();
        source.banchiCode2 = 番地コード2 == null ? RString.EMPTY : 番地コード2.getColumnValue();
        source.banchiCode3 = 番地コード3 == null ? RString.EMPTY : 番地コード3.getColumnValue();
        source.banchiCode4 = 番地コード4 == null ? RString.EMPTY : 番地コード4.getColumnValue();
        source.banchiCode1 = source.banchiCode1.concat(source.banchiCode2).concat(source.banchiCode3).concat(source.banchiCode4);
        AtenaKanaMeisho 氏名５０音カナ = 宛名.getKanaMeisho();
        source.kanaMeisho = 氏名５０音カナ == null ? RString.EMPTY : 氏名５０音カナ.getColumnValue();
        source.seibetsuCode = 宛名.getSeibetsuCode();
    }

    private void editAccessLog(KyotakuServiceKeikakuSaList 帳票情報, KyotakuServiceKeikakuSakuseiSource source)
            throws NullPointerException, IllegalArgumentException {
        if (帳票情報.get被保険者番号() != null) {
            HihokenshaNo 被保険者番号 = 帳票情報.get被保険者番号();
            source.listList1_1 = 被保険者番号.getColumnValue();
            if (帳票情報.get識別コード() != null) {
                PersonalData personalData = PersonalData.of(帳票情報.get識別コード(),
                        new ExpandedInformation(new Code("003"), 文_被保険者番号, 被保険者番号.getColumnValue()));
                AccessLogger.log(AccessLogType.照会, personalData);
            }
        }
    }

    private RString パターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

}
