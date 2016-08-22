/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen.GemmenKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenGaitoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200004.ShakaiFukushiHojinReportSourse;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人軽減認定者リストEditorです。
 *
 * @reamsid_L DBD-3830-060 tianyh
 */
public class ShakaiFukushiHojinKeigenEditor implements IShakaiFukushiHojinKeigenEditor {

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final RString 承認する = new RString("1");
    private static final RString 居宅サービスのみ = new RString("居宅サービスのみ");
    private static final RString 居住費食費のみ = new RString("居住費・食費のみ");
    private static final RString 旧措ユ個のみ = new RString("旧措ユ個のみ");
    private static final RString POINT = new RString("、");
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private final ShakaiFukushiHojinKeigenGaitoshaIchiranEntity 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final RString 帳票タイトル;
    private final int index;
    private final YMDHMS 帳票作成日時;

    /**
     * インスタンスを生成します
     *
     * @param 帳票情報 ShakaiFukushiHojinKeigenGaitoshaIchiranEntity
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 帳票タイトル RString
     * @param 帳票作成日時 YMDHMS
     * @param index int
     */
    public ShakaiFukushiHojinKeigenEditor(ShakaiFukushiHojinKeigenGaitoshaIchiranEntity 帳票情報,
            Association association, IOutputOrder iOutputOrder, RString 帳票タイトル, YMDHMS 帳票作成日時, int index) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.帳票タイトル = 帳票タイトル;
        this.index = index;
        this.帳票作成日時 = 帳票作成日時;
    }

    @Override
    public ShakaiFukushiHojinReportSourse edit(ShakaiFukushiHojinReportSourse source) {
        setsource(source);
        return source;
    }

    private void setsource(ShakaiFukushiHojinReportSourse source) {
        source.printTimeStamp = 帳票作成日時.toDateString();
        source.title = 帳票タイトル;
        if (null != association) {
            source.hokenshaNo = this.association.get地方公共団体コード().value();
            source.hokenshaName = this.association.get市町村名();
        }
        if (null != iOutputOrder) {
            setiOutputOrder(source);
        }
        source.list1_1 = 帳票情報.get被保険者番号().value();
        if (帳票情報.get宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(帳票情報.get宛名());
            source.list1_2 = kojin.get住所().get郵便番号().getYubinNo();
            source.list1_3 = kojin.get名称().getName().value();
            source.list1_4 = kojin.get年齢算出().get年齢();
            source.list2_2 = kojin.get住所().get全国住所コード().value();
            source.list2_3 = kojin.get住所().get住所();
            source.list2_4 = kojin.get住民状態().住民状態略称();
            source.list3_2 = kojin.get行政区画().getGyoseiku().getコード().value();
            source.list3_3 = kojin.get行政区画().getGyoseiku().get名称();

        }
        if (帳票情報.get社会福祉法人等利用者負担軽減の情報() != null) {
            set社会福祉法人等利用者負担軽減の情報(source);
        }
        if (帳票情報.get本人課税区分().equals(new RString("1"))) {
            source.list1_7 = new RString("課");
        }
        if (帳票情報.is所得税課税者()) {
            source.list1_8 = new RString("課");
        }
        if (帳票情報.is老齢福祉年金受給者()) {
            source.list1_9 = new RString("*");
        }
        if (帳票情報.is生活保護受給者()) {
            source.list1_10 = new RString("*");
        }
        if (帳票情報.get厚労省IF識別コード() != null && 帳票情報.get要介護状態区分コード() != null) {
            source.list1_12 = (YokaigoJotaiKubunSupport.toValue(
                    KoroshoInterfaceShikibetsuCode.toValue(帳票情報.get厚労省IF識別コード()), 帳票情報.get要介護状態区分コード()).getName());
        }
        if (帳票情報.get認定年月日() != null && !帳票情報.get認定年月日().isEmpty()) {
            source.list1_13 = 帳票情報.get認定年月日().wareki().toDateString();
        }
        source.list2_7 = 帳票情報.get入所施設コード();
        if (帳票情報.is旧措置者フラグ()) {
            source.list2_9 = new RString("該当");
        } else {
            source.list2_9 = new RString("非該当");
        }
        if (帳票情報.get認定有効期間開始日() != null && !帳票情報.get認定有効期間開始日().isEmpty()) {
            source.list2_10 = 帳票情報.get認定有効期間開始日().wareki().toDateString();
        }
        if (帳票情報.get認定有効期間終了日() != null && !帳票情報.get認定有効期間終了日().isEmpty()) {
            source.list3_7 = 帳票情報.get認定有効期間終了日().wareki().toDateString();
        }
        source.list3_6 = 帳票情報.get入所施設名称();
        source.list4_1 = 帳票情報.get計画事業者番号();
        if (帳票情報.is自己作成()) {
            source.list4_1 = new RString("自己作成");
        } else {
            source.list4_1 = 帳票情報.get計画事業者名();
        }
        if (帳票情報.get世帯員リスト().size() > index) {
            setsource世帯員1(source, index);
        }
        if (帳票情報.get世帯員リスト().size() > index + LISTINDEX_1) {
            setsource世帯員2(source, index + LISTINDEX_1);
        }
        if (帳票情報.get世帯員リスト().size() > index + LISTINDEX_2) {
            setsource世帯員3(source, index + LISTINDEX_2);
        }
        if (帳票情報.get世帯員リスト().size() > index + LISTINDEX_3) {
            setsource世帯員4(source, index + LISTINDEX_3);
        }

    }

    private void setiOutputOrder(ShakaiFukushiHojinReportSourse source) {
        List<ISetSortItem> 設定項目リスト = this.iOutputOrder.get設定項目リスト();
        for (int i = 0; i < 設定項目リスト.size(); i++) {
            if (i == LISTINDEX_0) {
                source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
                if (設定項目リスト.get(LISTINDEX_0).is改頁項目()) {
                    source.kaiPege1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
                }
            }
            if (i == LISTINDEX_1) {
                source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
                if (設定項目リスト.get(LISTINDEX_1).is改頁項目()) {
                    source.kaiPege2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
                }
            }
            if (i == LISTINDEX_2) {
                source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
                if (設定項目リスト.get(LISTINDEX_2).is改頁項目()) {
                    source.kaiPege3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
                }
            }
            if (i == LISTINDEX_3) {
                source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
                if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                    source.kaiPege4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
                }
            }
            if (i == LISTINDEX_4) {
                source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
                if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                    source.kaiPege5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
                }
            }
        }
    }

    private void set社会福祉法人等利用者負担軽減の情報(ShakaiFukushiHojinReportSourse source) {
        ShakaifukuRiyoshaFutanKeigen shakaifukuriyoshafutankeigen = new ShakaifukuRiyoshaFutanKeigen(帳票情報.get社会福祉法人等利用者負担軽減の情報());
        source.list1_5 = shakaifukuriyoshafutankeigen.get申請年月日().wareki().toDateString();
        source.list1_6 = shakaifukuriyoshafutankeigen.get決定年月日().wareki().toDateString();
        source.list2_1 = shakaifukuriyoshafutankeigen.get証記載保険者番号().value();
        source.list2_5 = shakaifukuriyoshafutankeigen.get適用開始年月日().wareki().toDateString();
        source.list2_6 = shakaifukuriyoshafutankeigen.get適用終了年月日().wareki().toDateString();
        source.list3_1 = shakaifukuriyoshafutankeigen.get確認番号();
        if (shakaifukuriyoshafutankeigen.get決定区分().equals(承認する)) {
            source.list3_4 = new RString("*");
        }
        if (shakaifukuriyoshafutankeigen.get軽減率_分母() != null && shakaifukuriyoshafutankeigen.get軽減率_分子() != null) {
            RString 軽減率 = new RString("");
            軽減率.concat(shakaifukuriyoshafutankeigen.get軽減率_分子().toString());
            軽減率.concat("/");
            軽減率.concat(shakaifukuriyoshafutankeigen.get軽減率_分母().toString());
            source.list3_5 = 軽減率;
        }
        source.list4_3 = GemmenKubun.toValue(shakaifukuriyoshafutankeigen.get減免区分()).get名称();
        RString 居宅サービス限定 = new RString("");
        if (shakaifukuriyoshafutankeigen.is居宅サービス限定()) {
            居宅サービス限定 = 居宅サービスのみ.concat(POINT);
        }
        if (shakaifukuriyoshafutankeigen.is居住費_食費のみ()) {
            居宅サービス限定 = 居宅サービス限定.concat(居住費食費のみ.concat(POINT));
        }
        if (shakaifukuriyoshafutankeigen.is旧措置者ユニット型個室のみ()) {
            居宅サービス限定 = 居宅サービス限定.concat(旧措ユ個のみ.concat(POINT));
        }
        if (居宅サービス限定 != null && !居宅サービス限定.isEmpty()) {
            int length = 居宅サービス限定.length();
            source.list4_4 = 居宅サービス限定.substring(NO_0, length - NO_1);
        }
    }

    private void setsource世帯員1(ShakaiFukushiHojinReportSourse source, int listindex) {
        if (帳票情報.get世帯員リスト().get(listindex).get世帯員宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(帳票情報.get世帯員リスト().get(listindex).get世帯員宛名());
            if (kojin.get名称() != null) {
                source.list1_14 = kojin.get名称().getName().value();
            }
            if (kojin.get住民状態() != null) {
                source.list1_15 = kojin.get住民状態().住民状態略称();
            }
        }
        if (!帳票情報.get世帯員リスト().get(listindex).get本人課税区分().isNullOrEmpty()
                && 帳票情報.get世帯員リスト().get(listindex).get本人課税区分().equals(new RString("1"))) {
            source.list1_16 = new RString("課");
        }
        if (帳票情報.get世帯員リスト().get(listindex).get課税所得額() != null
                && 帳票情報.get世帯員リスト().get(listindex).get課税所得額().intValue() <= 0) {
            source.list1_17 = new RString("課");
        }
    }

    private void setsource世帯員2(ShakaiFukushiHojinReportSourse source, int listindex) {
        if (帳票情報.get世帯員リスト().get(listindex).get世帯員宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(帳票情報.get世帯員リスト().get(listindex).get世帯員宛名());
            if (kojin.get名称() != null) {
                source.list2_11 = kojin.get名称().getName().value();
            }
            if (kojin.get住民状態() != null) {
                source.list2_12 = kojin.get住民状態().住民状態略称();
            }
        }
        if (!帳票情報.get世帯員リスト().get(listindex).get本人課税区分().isNullOrEmpty()
                && 帳票情報.get世帯員リスト().get(listindex).get本人課税区分().equals(new RString("1"))) {
            source.list2_13 = new RString("課");
        }
        if (帳票情報.get世帯員リスト().get(listindex).get課税所得額() != null
                && 帳票情報.get世帯員リスト().get(listindex).get課税所得額().intValue() <= 0) {
            source.list2_14 = new RString("課");
        }
    }

    private void setsource世帯員3(ShakaiFukushiHojinReportSourse source, int listindex) {
        if (帳票情報.get世帯員リスト().get(listindex).get世帯員宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(帳票情報.get世帯員リスト().get(listindex).get世帯員宛名());
            if (kojin.get名称() != null) {
                source.list3_8 = kojin.get名称().getName().value();
            }
            if (kojin.get住民状態() != null) {
                source.list3_9 = kojin.get住民状態().住民状態略称();
            }
        }
        if (!帳票情報.get世帯員リスト().get(listindex).get本人課税区分().isNullOrEmpty()
                && 帳票情報.get世帯員リスト().get(listindex).get本人課税区分().equals(new RString("1"))) {
            source.list3_10 = new RString("課");
        }
        if (帳票情報.get世帯員リスト().get(listindex).get課税所得額() != null
                && 帳票情報.get世帯員リスト().get(listindex).get課税所得額().intValue() <= 0) {
            source.list3_11 = new RString("課");
        }
    }

    private void setsource世帯員4(ShakaiFukushiHojinReportSourse source, int listindex) {
        if (帳票情報.get世帯員リスト().get(listindex).get世帯員宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(帳票情報.get世帯員リスト().get(listindex).get世帯員宛名());
            if (kojin.get名称() != null) {
                source.list4_5 = kojin.get名称().getName().value();
            }
            if (kojin.get住民状態() != null) {
                source.list4_6 = kojin.get住民状態().住民状態略称();
            }
        }
        if (!帳票情報.get世帯員リスト().get(listindex).get本人課税区分().isNullOrEmpty()
                && 帳票情報.get世帯員リスト().get(listindex).get本人課税区分().equals(new RString("1"))) {
            source.list4_7 = new RString("課");
        }
        if (帳票情報.get世帯員リスト().get(listindex).get課税所得額() != null
                && 帳票情報.get世帯員リスト().get(listindex).get課税所得額().intValue() <= 0) {
            source.list4_8 = new RString("課");
        }
    }
}
