/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2920001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.iraijohodatatorikomi.NinteiShinseiJohoIraiJohoData;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.dgTorikomiFileIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 依頼情報データ受取（オルカ）のHandlerクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public class IraiJohoDataTorikomiHandler {

    private static final RString 同意する = new RString("1");
    private static final RString 有 = new RString("1");
    private final IraiJohoDataTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IraiJohoDataTorikomiDiv
     */
    public IraiJohoDataTorikomiHandler(IraiJohoDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 一覧エリアの設定処理です。
     *
     * @param csvEntityList List<IraiJohoDataTorikomiCsvEntity>
     */
    public void set一覧エリア(List<IraiJohoDataTorikomiCsvEntity> csvEntityList) {
        List<dgTorikomiFileIchiran_Row> rowlist = new ArrayList<>();
        for (IraiJohoDataTorikomiCsvEntity csvEntity : csvEntityList) {
            dgTorikomiFileIchiran_Row row1 = new dgTorikomiFileIchiran_Row();
            row1.setHokenshaBango(csvEntity.get保険者番号());
            row1.setHihokenshaBango(csvEntity.get被保険者番号());
            row1.setShinseibi(csvEntity.get申請日());
            row1.setHihokenshaShimei(csvEntity.get患者名());
            row1.setSeninengapi(csvEntity.get生年月日());
            row1.setSeibetu(csvEntity.get性別());
            row1.setYubinBangou(csvEntity.get郵便番号());
            row1.setJyusyo(csvEntity.get住所());
            row1.setIryouKikanMei(csvEntity.get医療機関名());
            row1.setShuziiMei(csvEntity.get医師氏名());
            row1.setKiguusuu(new RString("1"));
            rowlist.add(row1);
            dgTorikomiFileIchiran_Row row2 = new dgTorikomiFileIchiran_Row();
            row2.setKiguusuu(new RString("0"));
            row2.setDeleteButtonState(DataGridButtonState.Disabled);
            rowlist.add(row2);
        }
        div.getDgTorikomiFileIchiran().setDataSource(rowlist);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("nyuryokuCyeku"), true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("insatu"), true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("koushin"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("nyuryokuCyeku"), false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("insatu"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("koushin"), true);
    }

    /**
     * 一覧エリアの設定処理です。
     *
     * @param ninteiShinseiJohoList List<NinteiShinseiJohoIraiJohoData>
     */
    public void set一覧エリア_入力チェック(List<NinteiShinseiJohoIraiJohoData> ninteiShinseiJohoList) {
        List<dgTorikomiFileIchiran_Row> rowlist = new ArrayList<>();
        List<dgTorikomiFileIchiran_Row> rowList = div.getDgTorikomiFileIchiran().getDataSource();
        for (int i = 0; i < ninteiShinseiJohoList.size(); i++) {
            if (i == 0) {
                dgTorikomiFileIchiran_Row row1 = rowList.get(i);
                row1.setShinseishoKanriNo(nullToEmpty(ninteiShinseiJohoList.get(i).get申請書管理番号()));
                row1.setKoroshoIfShikibetsuCode(nullToEmpty(ninteiShinseiJohoList.get(i).get厚労省IF識別コード()));
                row1.getIkenshoIraiRirekiNo().setValue(new Decimal(ninteiShinseiJohoList.get(i).get主治医意見書作成依頼履歴番号()));
                row1.setShujiiCode(ninteiShinseiJohoList.get(i).get主治医コード());
                row1.setShujiiIryokikanCode(ninteiShinseiJohoList.get(i).get主治医医療機関コード());
                rowlist.add(row1);
                dgTorikomiFileIchiran_Row row2 = rowList.get(i + 1);
                row2.setHokenshaBango(nullToEmpty(ninteiShinseiJohoList.get(i).get保険者番号()));
                row2.setHihokenshaBango(nullToEmpty(ninteiShinseiJohoList.get(i).get被保険者番号()));
                row2.setShinseibi(nullToEmpty(ninteiShinseiJohoList.get(i).get認定申請年月日()));
                row2.setHihokenshaShimei(nullToEmpty(ninteiShinseiJohoList.get(i).get被保険者氏名()));
                row2.setSeninengapi(nullToEmpty(ninteiShinseiJohoList.get(i).get生年月日()));
                row2.setSeibetu(nullToEmpty(ninteiShinseiJohoList.get(i).get性別()));
                row2.setYubinBangou(nullToEmpty(ninteiShinseiJohoList.get(i).get郵便番号()));
                row2.setJyusyo(nullToEmpty(ninteiShinseiJohoList.get(i).get住所()));
                row2.setIryouKikanMei(nullToEmpty(ninteiShinseiJohoList.get(i).get医療機関名称()));
                row2.setShuziiMei(nullToEmpty(ninteiShinseiJohoList.get(i).get主治医氏名()));
                row2.setShinseishoKanriNo(nullToEmpty(ninteiShinseiJohoList.get(i).get申請書管理番号()));
                row2.setKoroshoIfShikibetsuCode(nullToEmpty(ninteiShinseiJohoList.get(i).get厚労省IF識別コード()));
                row2.getIkenshoIraiRirekiNo().setValue(new Decimal(ninteiShinseiJohoList.get(i).get主治医意見書作成依頼履歴番号()));
                row2.setShujiiCode(ninteiShinseiJohoList.get(i).get主治医コード());
                row2.setShujiiIryokikanCode(ninteiShinseiJohoList.get(i).get主治医医療機関コード());
                rowlist.add(row2);
            } else {
                dgTorikomiFileIchiran_Row row1 = rowList.get(2 * i);
                row1.setShinseishoKanriNo(nullToEmpty(ninteiShinseiJohoList.get(i).get申請書管理番号()));
                row1.setKoroshoIfShikibetsuCode(nullToEmpty(ninteiShinseiJohoList.get(i).get厚労省IF識別コード()));
                row1.getIkenshoIraiRirekiNo().setValue(new Decimal(ninteiShinseiJohoList.get(i).get主治医意見書作成依頼履歴番号()));
                row1.setShujiiCode(ninteiShinseiJohoList.get(i).get主治医コード());
                row1.setShujiiIryokikanCode(ninteiShinseiJohoList.get(i).get主治医医療機関コード());
                rowlist.add(row1);
                dgTorikomiFileIchiran_Row row2 = rowList.get(2 * i + 1);
                row2.setHokenshaBango(nullToEmpty(ninteiShinseiJohoList.get(i).get保険者番号()));
                row2.setHihokenshaBango(nullToEmpty(ninteiShinseiJohoList.get(i).get被保険者番号()));
                row2.setShinseibi(nullToEmpty(ninteiShinseiJohoList.get(i).get認定申請年月日()));
                row2.setHihokenshaShimei(nullToEmpty(ninteiShinseiJohoList.get(i).get被保険者氏名()));
                row2.setSeninengapi(nullToEmpty(ninteiShinseiJohoList.get(i).get生年月日()));
                row2.setSeibetu(nullToEmpty(ninteiShinseiJohoList.get(i).get性別()));
                row2.setYubinBangou(nullToEmpty(ninteiShinseiJohoList.get(i).get郵便番号()));
                row2.setJyusyo(nullToEmpty(ninteiShinseiJohoList.get(i).get住所()));
                row2.setIryouKikanMei(nullToEmpty(ninteiShinseiJohoList.get(i).get医療機関名称()));
                row2.setShuziiMei(nullToEmpty(ninteiShinseiJohoList.get(i).get主治医氏名()));
                row2.setShinseishoKanriNo(nullToEmpty(ninteiShinseiJohoList.get(i).get申請書管理番号()));
                row2.setKoroshoIfShikibetsuCode(nullToEmpty(ninteiShinseiJohoList.get(i).get厚労省IF識別コード()));
                row2.getIkenshoIraiRirekiNo().setValue(new Decimal(ninteiShinseiJohoList.get(i).get主治医意見書作成依頼履歴番号()));
                row2.setShujiiCode(ninteiShinseiJohoList.get(i).get主治医コード());
                row2.setShujiiIryokikanCode(ninteiShinseiJohoList.get(i).get主治医医療機関コード());
                rowlist.add(row2);
            }
        }
        div.getDgTorikomiFileIchiran().getDataSource().clear();
        div.getDgTorikomiFileIchiran().setDataSource(rowlist);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("insatu"), false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("koushin"), false);
    }

    /**
     * 帳票出力用情報を編集する。
     *
     * @param csvEntity IraiJohoDataTorikomiCsvEntity
     * @return IkenshokinyuyoshiBusiness
     */
    public IkenshokinyuyoshiBusiness 帳票出力用情報の編集(IraiJohoDataTorikomiCsvEntity csvEntity) {
        IkenshokinyuyoshiBusiness business = new IkenshokinyuyoshiBusiness();
        business.setタイムスタンプ(csvEntity.getタイムスタンプ());
        business.set記入日(RString.isNullOrEmpty(csvEntity.get記入日()) ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get記入日()));
        business.set事業所番号(csvEntity.get事業所番号());
        business.set送付日(RString.isNullOrEmpty(csvEntity.get送付日()) ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get送付日()));
        business.set依頼番号(csvEntity.get依頼番号());
        business.set保険者番号(csvEntity.get保険者番号());
        business.set保険者名称(csvEntity.get保険者名称());
        business.set被保険者番号(csvEntity.get被保険者番号());
        business.set申請日(RString.isNullOrEmpty(csvEntity.get申請日()) ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get申請日()));
        business.set作成依頼日(RString.isNullOrEmpty(csvEntity.get作成依頼日()) ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get作成依頼日()));
        business.set患者名(csvEntity.get患者名());
        business.set患者名かな(csvEntity.get患者名かな());
        business.set生年月日(RString.isNullOrEmpty(csvEntity.get生年月日()) ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get生年月日()));
        business.set患者_年齢(csvEntity.get患者_年齢());
        business.set性別(csvEntity.get性別());
        business.set郵便番号(csvEntity.get郵便番号());
        business.set住所(csvEntity.get住所());
        business.set連絡先電話番号(csvEntity.get連絡先電話番号());
        business.set同意の有無(同意する.equals(csvEntity.get同意の有無()));
        business.set医師氏名(csvEntity.get医師氏名());
        business.set医師番号(csvEntity.get医師番号());
        business.set医療機関名(csvEntity.get医療機関名());
        business.set医療機関郵便番号(RString.isNullOrEmpty(csvEntity.get医療機関郵便番号())
                ? YubinNo.EMPTY : new YubinNo(csvEntity.get医療機関郵便番号()));
        business.set医療機関所在地(csvEntity.get医療機関所在地());
        business.set医療機関電話番号(csvEntity.get医療機関電話番号());
        business.set医療機関FAX番号(csvEntity.get医療機関FAX番号());
        business.set最終診察日(RString.isNullOrEmpty(csvEntity.get最終診察日()) ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get最終診察日()));
        business.set意見書作成回数(csvEntity.get意見書作成回数());
        business.set種別(csvEntity.get種別());
        business.set他科受診有無(有.equals(csvEntity.get他科受診有無()));
        business.set他科名(csvEntity.get他科名());
        business.setその他の他科名(csvEntity.getその他の他科名());
        business.set診断名1(csvEntity.get診断名1());
        business.set発症年月日1(RString.isNullOrEmpty(csvEntity.get発症年月日1())
                ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get発症年月日1()));
        business.set診断名2(csvEntity.get診断名2());
        business.set発症年月日2(RString.isNullOrEmpty(csvEntity.get発症年月日2())
                ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get発症年月日2()));
        business.set診断名3(csvEntity.get診断名3());
        business.set発症年月日3(RString.isNullOrEmpty(csvEntity.get発症年月日3())
                ? FlexibleDate.EMPTY : new FlexibleDate(csvEntity.get発症年月日3()));
        business.set症状安定性(csvEntity.get症状安定性());
        business.set症状不安定時の具体的状況(csvEntity.get症状不安定時の具体的状況());
        business.set経過及び治療内容(csvEntity.get経過及び治療内容());
        business.set処置内容(csvEntity.get処置内容());
        business.set特別な対応(csvEntity.get特別な対応());
        business.set失禁への対応(csvEntity.get失禁への対応());
        business.set寝たきり度(csvEntity.get寝たきり度());
        business.set認知症高齢者の日常生活自立度(csvEntity.get認知症高齢者の日常生活自立度());
        business.set短期記憶(csvEntity.get短期記憶());
        business.set認知能力(csvEntity.get認知能力());
        business.set伝達能力(csvEntity.get伝達能力());
        business.set周辺症状有無(csvEntity.get周辺症状有無());
        business.set周辺症状詳細(csvEntity.get周辺症状詳細());
        business.setその他の周辺症状(csvEntity.getその他の周辺症状());
        business.set精神神経症状有無(csvEntity.get精神神経症状有無());
        business.set精神神経症状名(csvEntity.get精神神経症状名());
        business.set専門医受診有無(csvEntity.get専門医受診有無());
        business.set専門医受診科名(csvEntity.get専門医受診科名());
        business.set利き腕(csvEntity.get利き腕());
        business.set身長(csvEntity.get身長());
        business.set体重(csvEntity.get体重());
        business.set体重の変化(csvEntity.get体重の変化());
        business.set四肢欠損(csvEntity.get四肢欠損());
        business.set四肢欠損部位(csvEntity.get四肢欠損部位());
        business.set麻痺(csvEntity.get麻痺());
        business.set麻痺右上肢(csvEntity.get麻痺右上肢());
        business.set麻痺右上肢程度(csvEntity.get麻痺右上肢程度());
        business.set麻痺左上肢(csvEntity.get麻痺左上肢());
        business.set麻痺左上肢程度(csvEntity.get麻痺左上肢程度());
        business.set麻痺右下肢(csvEntity.get麻痺右下肢());
        business.set麻痺右下肢程度(csvEntity.get麻痺右下肢程度());
        business.set麻痺左下肢(csvEntity.get麻痺左下肢());
        business.set麻痺左下肢程度(csvEntity.get麻痺左下肢程度());
        business.set麻痺その他(csvEntity.get麻痺その他());
        business.set麻痺その他部位(csvEntity.get麻痺その他部位());
        business.set麻痺その他程度(csvEntity.get麻痺その他程度());
        business.set筋力低下(csvEntity.get筋力低下());
        business.set筋力低下部位(csvEntity.get筋力低下部位());
        business.set筋力低下程度(csvEntity.get筋力低下程度());
        business.set関節拘縮(csvEntity.get関節拘縮());
        business.set関節拘縮部位(csvEntity.get関節拘縮部位());
        business.set関節拘縮程度(csvEntity.get関節拘縮程度());
        business.set関節痛み(csvEntity.get関節痛み());
        business.set関節痛み部位(csvEntity.get関節痛み部位());
        business.set関節痛み程度(csvEntity.get関節痛み程度());
        business.set失調不随意運動(csvEntity.get失調不随意運動());
        business.set失調不随意運動上肢(csvEntity.get失調不随意運動上肢());
        business.set失調不随意運動下肢(csvEntity.get失調不随意運動下肢());
        business.set体幹(csvEntity.get体幹());
        business.set褥瘡(csvEntity.get褥瘡());
        business.set褥瘡部位(csvEntity.get褥瘡部位());
        business.set褥瘡程度(csvEntity.get褥瘡程度());
        business.setその他皮膚疾患(csvEntity.getその他皮膚疾患());
        business.setその他皮膚疾患部(csvEntity.getその他皮膚疾患部());
        business.setその他皮膚疾程度(csvEntity.getその他皮膚疾程度());
        business.set屋外歩行(csvEntity.get屋外歩行());
        business.set車いすの使用(csvEntity.get車いすの使用());
        business.set歩行補助具_装具の使用(csvEntity.get歩行補助具_装具の使用());
        business.set食事行為(csvEntity.get食事行為());
        business.set現在の栄養状態(csvEntity.get現在の栄養状態());
        business.set栄養_食生活上の留意点(csvEntity.get栄養_食生活上の留意点());
        business.set発生可能性状態(csvEntity.get発生可能性状態());
        business.setその他の状態名(csvEntity.getその他の状態名());
        business.set対処方針内容(csvEntity.get対処方針内容());
        business.setサービス利用による生活機能の維持_改善の見通し(csvEntity.getサービス利用による生活機能の維持_改善の見通し());
        business.set医学的管理の必要性(csvEntity.get医学的管理の必要性());
        business.setその他の医学的管理(csvEntity.getその他の医学的管理());
        business.setサービス提供血圧(csvEntity.getサービス提供血圧());
        business.setサービス提供血圧留意事項(csvEntity.getサービス提供血圧留意事項());
        business.setサービス提供摂食(csvEntity.getサービス提供摂食());
        business.setサービス提供摂食留意事項(csvEntity.getサービス提供摂食留意事項());
        business.setサービス提供嚥下(csvEntity.getサービス提供嚥下());
        business.setサービス提供嚥下留意事項(csvEntity.getサービス提供嚥下留意事項());
        business.setサービス提供移動(csvEntity.getサービス提供移動());
        business.setサービス提供移動留意事項(csvEntity.getサービス提供移動留意事項());
        business.setサービス提供運動(csvEntity.getサービス提供運動());
        business.setサービス提供運動留意事項(csvEntity.getサービス提供運動留意事項());
        business.setサービス提供その他の留意事項(csvEntity.getサービス提供その他の留意事項());
        business.set感染症有無(csvEntity.get感染症有無());
        business.set感染症名(csvEntity.get感染症名());
        business.setその他特記事項(csvEntity.getその他特記事項());
        return business;
    }

    private RString nullToEmpty(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }
}
