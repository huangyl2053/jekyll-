/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.nenreikaikyuriyojokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.nenreikaikyuriyojokyo.SyorikekkaCyouHyouEucCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpKyufujissekiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpSyuturyokuYoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 給付実績集計データ取得、「給付実績データ一時TBL」に登録するEditクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
public class KyufujissekiEdit {

    private static final RString 訪問通所計 = new RString("■訪問通所計サービス");
    private static final RString 短期入所系 = new RString("■短期入所系サービス");
    private static final RString 標準的居宅 = new RString("■標準的居宅サービス(訪問通所系サービス＋短期入所計サービス＋居宅量管理指導)");
    private static final RString 居宅 = new RString("■居宅サービス計(標準的居宅サービス＋特定施設生活介護)");
    private static final RString 施設 = new RString("■施設サービス計");
    private static final RString 地域密着 = new RString("■地域密着サービス計");
    private static final RString 総合計 = new RString("■総合計");
    private static final RString 空 = new RString("■空");
    private static final RString 訪問介護 = new RString("(介護予防)訪問介護");
    private static final RString 訪問入浴介護 = new RString("(介護予防)訪問入浴介護");
    private static final RString 訪問看護 = new RString("(介護予防)訪問看護");
    private static final RString 訪問リハビリ = new RString("(介護予防)訪問リハビリ");
    private static final RString 通所介護 = new RString("(介護予防)通所介護");
    private static final RString 通所リハビリ = new RString("(介護予防)通所リハビリ");
    private static final RString 福祉用具貸与 = new RString("(介護予防)福祉用具貸与");
    private static final RString 短期入所生活介護 = new RString("(介護予防)短期入所生活介護");
    private static final RString 短期入所老健施設 = new RString("(介護予防)短期入所老健施設");
    private static final RString 短期入所医療施設 = new RString("(介護予防)短期入所医療施設");
    private static final RString 居宅療養管理指導 = new RString("(介護予防)居宅療養管理指導");
    private static final RString 特定施設生活介護 = new RString("(介護予防)特定施設生活介護(短期以外)");
    private static final RString 特定施設生活介護短期 = new RString("(介護予防)特定施設生活介護(短期)");
    private static final RString 夜間対応型訪問介護 = new RString("夜間対応型訪問介護");
    private static final RString 認知症対応型通所介護 = new RString("(介護予防)認知症対応型通所介護");
    private static final RString 小規模多機能型居宅介護 = new RString("(介護予防)小規模多機能型居宅介護");
    private static final RString 認知症対応型共同生活 = new RString("(介護予防)認知症対応型共同生活");
    private static final RString 地域密着型短期以外 = new RString("地域密着型特定施設入居者生活（短期以外）");
    private static final RString 地域密着型短期 = new RString("地域密着型特定施設入居者生活（短期）");
    private static final RString 認知症対応型共同生活短期 = new RString("(介護予防)認知症対応型共同生活(短期)");
    private static final RString 随時対応型訪問介護看護 = new RString("定期巡回・随時対応型訪問介護看護");
    private static final RString 複合型サービス = new RString("複合型サービス");
    private static final RString 地域密着型介護老人福祉施設 = new RString("地域密着型介護老人福祉施設");
    private static final RString 特定福祉用具販売費 = new RString("(介護予防)特定福祉用具販売費");
    private static final RString 住宅改修費 = new RString("(介護予防)住宅改修費");
    private static final RString 介護予防支援 = new RString("居宅介護支援・介護予防支援");
    private static final RString 介護福祉施設 = new RString("介護福祉施設");
    private static final RString 介護老健施設 = new RString("介護老健施設");
    private static final RString 介護医療施設 = new RString("介護医療施設");
    private static final RString 市町村特別給付 = new RString("市町村特別給付");
    private static final RString 特定入所者介護食費 = new RString("(介護予防)特定入所者介護サービス費(食費)");
    private static final RString 特定入所者介護居住費 = new RString("(介護予防)特定入所者介護サービス費(居住費)");
    private static final RString 年齢階級1 = new RString("40歳～49歳");
    private static final RString 年齢階級2 = new RString("50歳～59歳");
    private static final RString 年齢階級3 = new RString("60歳～64歳");
    private static final RString 年齢階級4 = new RString("２号計");
    private static final RString 年齢階級5 = new RString("65歳～69歳");
    private static final RString 年齢階級6 = new RString("70歳～74歳");
    private static final RString 年齢階級7 = new RString("75歳～79歳");
    private static final RString 年齢階級8 = new RString("80歳～84歳");
    private static final RString 年齢階級9 = new RString("85歳～89歳");
    private static final RString 年齢階級10 = new RString("90歳～94歳");
    private static final RString 年齢階級11 = new RString("95歳～99歳");
    private static final RString 年齢階級12 = new RString("100歳以上");
    private static final RString 年齢階級13 = new RString("１号計");
    private static final RString 年齢階級14 = new RString("総合計");
    private static final RString NO_1 = new RString("1");
    private static final RString NO_2 = new RString("2");
    private boolean first = true;

    /**
     * editEntityメッソドです。
     *
     * @param entity NenreikaikyuRiyojokyoRelateEntity
     * @return TmpKyufujissekiRelateEntity
     */
    public TmpKyufujissekiRelateEntity editEntity(NenreikaikyuRiyojokyoRelateEntity entity) {
        TmpKyufujissekiRelateEntity tmpEntity = new TmpKyufujissekiRelateEntity();
        tmpEntity.setHiHokenshaNo(entity.getHiHokenshaNo());
        tmpEntity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        tmpEntity.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        tmpEntity.setUmareYMD(entity.getUmareYMD());
        tmpEntity.setServiceSyuruiCode(entity.getServiceSyuruiCode());
        tmpEntity.setServiceKomokuCode(entity.getServiceKomokuCode());
        tmpEntity.setMeisho(entity.getMeisho());
        return tmpEntity;

    }

    /**
     * set出力用一時TBL
     *
     * @return List<TmpSyuturyokuYoRelateEntity>
     */
    public List<TmpSyuturyokuYoRelateEntity> set出力用一時TBL() {
        List<TmpSyuturyokuYoRelateEntity> 一時EntityList = new ArrayList<>();
        List<RString> nenreiKaikyuList = new ArrayList<>();
        nenreiKaikyuList.add(年齢階級1);
        nenreiKaikyuList.add(年齢階級2);
        nenreiKaikyuList.add(年齢階級3);
        nenreiKaikyuList.add(年齢階級4);
        nenreiKaikyuList.add(年齢階級5);
        nenreiKaikyuList.add(年齢階級6);
        nenreiKaikyuList.add(年齢階級7);
        nenreiKaikyuList.add(年齢階級8);
        nenreiKaikyuList.add(年齢階級9);
        nenreiKaikyuList.add(年齢階級10);
        nenreiKaikyuList.add(年齢階級11);
        nenreiKaikyuList.add(年齢階級12);
        nenreiKaikyuList.add(年齢階級13);
        nenreiKaikyuList.add(年齢階級14);
        List<RString> serviceshuruiList = new ArrayList<>();
        serviceshuruiList.add(訪問通所計);
        serviceshuruiList.add(短期入所系);
        serviceshuruiList.add(標準的居宅);
        serviceshuruiList.add(居宅);
        serviceshuruiList.add(施設);
        serviceshuruiList.add(地域密着);
        serviceshuruiList.add(総合計);
        serviceshuruiList.add(空);
        serviceshuruiList.add(訪問介護);
        serviceshuruiList.add(訪問入浴介護);
        serviceshuruiList.add(訪問看護);
        serviceshuruiList.add(訪問リハビリ);
        serviceshuruiList.add(通所介護);
        serviceshuruiList.add(通所リハビリ);
        serviceshuruiList.add(福祉用具貸与);
        serviceshuruiList.add(短期入所生活介護);
        serviceshuruiList.add(短期入所老健施設);
        serviceshuruiList.add(短期入所医療施設);
        serviceshuruiList.add(居宅療養管理指導);
        serviceshuruiList.add(特定施設生活介護);
        serviceshuruiList.add(特定施設生活介護短期);
        serviceshuruiList.add(夜間対応型訪問介護);
        serviceshuruiList.add(認知症対応型通所介護);
        serviceshuruiList.add(小規模多機能型居宅介護);
        serviceshuruiList.add(認知症対応型共同生活);
        serviceshuruiList.add(地域密着型短期以外);
        serviceshuruiList.add(地域密着型短期);
        serviceshuruiList.add(認知症対応型共同生活短期);
        serviceshuruiList.add(随時対応型訪問介護看護);
        serviceshuruiList.add(複合型サービス);
        serviceshuruiList.add(地域密着型介護老人福祉施設);
        serviceshuruiList.add(特定福祉用具販売費);
        serviceshuruiList.add(住宅改修費);
        serviceshuruiList.add(介護予防支援);
        serviceshuruiList.add(介護福祉施設);
        serviceshuruiList.add(介護老健施設);
        serviceshuruiList.add(介護医療施設);
        serviceshuruiList.add(市町村特別給付);
        serviceshuruiList.add(特定入所者介護食費);
        serviceshuruiList.add(特定入所者介護居住費);
        for (int i = 0; i < serviceshuruiList.size(); i++) {
            set一時Entity(一時EntityList, nenreiKaikyuList, i, serviceshuruiList);
        }
        return 一時EntityList;
    }

    private void set一時Entity(List<TmpSyuturyokuYoRelateEntity> 一時EntityList,
            List<RString> nenreiKaikyuList, int i, List<RString> serviceshuruiList) {
        for (int j = 0; j < nenreiKaikyuList.size(); j++) {
            TmpSyuturyokuYoRelateEntity 一時Entity = new TmpSyuturyokuYoRelateEntity();
            一時Entity.setPageNo(new RString(String.valueOf(i / 2 + 1)));
            一時Entity.setServiceSyuruiCodeMei(serviceshuruiList.get(i));
            if (i % 2 == 0) {
                一時Entity.setNo(NO_1);
            } else {
                一時Entity.setNo(NO_2);
            }
            一時Entity.setHiGaitou(Decimal.ZERO);
            一時Entity.setYoSien1(Decimal.ZERO);
            一時Entity.setYoSien2(Decimal.ZERO);
            一時Entity.setKeikatekiYoSien(Decimal.ZERO);
            一時Entity.setYouKaigo1(Decimal.ZERO);
            一時Entity.setYouKaigo2(Decimal.ZERO);
            一時Entity.setYouKaigo3(Decimal.ZERO);
            一時Entity.setYouKaigo4(Decimal.ZERO);
            一時Entity.setYouKaigo5(Decimal.ZERO);
            一時Entity.setGoikei(Decimal.ZERO);
            一時Entity.setBikou(RString.EMPTY);
            一時Entity.setKubun(nenreiKaikyuList.get(j));
            一時EntityList.add(一時Entity);
        }
    }

    /**
     * ファイル出力(処理結果確認リスト)です
     *
     * @param entity SyorikekkatempTblEntity
     * @return SyorikekkaCyouHyouEucCsvEntity
     */
    public SyorikekkaCyouHyouEucCsvEntity setCsvEntity(SyorikekkatempTblEntity entity) {
        SyorikekkaCyouHyouEucCsvEntity csvEntity = new SyorikekkaCyouHyouEucCsvEntity();
        if (first) {
            first = false;
            csvEntity.set作成日時(setDateFormat(new RString(RDateTime.now().toString())));
        }
        csvEntity.set処理名(entity.getShoriMei());
        csvEntity.set証記載保険者番号(RString.EMPTY);
        csvEntity.set被保険者番号(entity.getHiHokenshaNo().value());
        csvEntity.set被保険者氏名(entity.getHiHokenshaKana());
        csvEntity.setサービス提供年月(entity.getServiceTeikyoYM().toDateString());
        csvEntity.set事業者番号(RString.EMPTY);
        csvEntity.set入力識別番号(RString.EMPTY);
        csvEntity.set通し番号(RString.EMPTY);
        csvEntity.setサービス種類コード(RString.EMPTY);
        csvEntity.setエラー内容(entity.getErrorMsg());
        csvEntity.set備考(entity.getBikou());
        return csvEntity;

    }

    private RString setDateFormat(RString date) {
        RString formatDate = RString.EMPTY;
        if (!RString.isNullOrEmpty(date)) {
            formatDate = new FlexibleDate(date).wareki().toDateString();
        }
        return formatDate;
    }
}
