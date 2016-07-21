/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumifoutput.ichijihanteizumi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteizumifoutput.IchijiHanteizumIfOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ChosaItemJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.NinteichosaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.NinteichosahyoServiceJokyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ShujiiIkenshoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * バッチ設計_DBE491001_日次進捗データ作成Businessクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
public class IchijiHanteizumIfOutputBusiness {

    private int 項番 = 0;
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
    private static final RString 厚労省IF識別コード = new RString("厚労省IF識別コード");
    private static final RString 厚労省IF識別コード_99A = new RString("99A");
    private static final RString 厚労省IF識別コード_02A = new RString("02A");
    private static final RString 厚労省IF識別コード_06A = new RString("06A");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");

    /**
     *
     * @param entity NinteichosahyoServiceJokyoRelateEntity
     * @param temoTableEntity NinteichosaJohoTempTableEntity
     * @param map Map<String, RString>
     * @param サービスの状況一時リスト List<NinteichosaJohoTempTableEntity>
     * @return temoTableEntity NinteichosaJohoTempTableEntity
     */
    public NinteichosaJohoTempTableEntity getサービスの状況一時テーブル(NinteichosahyoServiceJokyoRelateEntity entity,
            NinteichosaJohoTempTableEntity temoTableEntity, Map<String, RString> map,
            List<NinteichosaJohoTempTableEntity> サービスの状況一時リスト) {
        if (map.get(申請書管理番号.toString()).equals(nullToEmpty(entity.getShinseishoKanriNo()))
                && map.get(厚労省IF識別コード.toString()).equals(nullToEmpty(entity.getKoroshoIfShikibetsuCode()))) {
            switch (nullToEmpty(entity.getRemban()).toString()) {
                case "2":
                    temoTableEntity.setRemban2(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "3":
                    temoTableEntity.setRemban3(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "4":
                    temoTableEntity.setRemban4(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "5":
                    temoTableEntity.setRemban5(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "6":
                    temoTableEntity.setRemban6(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "7":
                    temoTableEntity.setRemban7(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "8":
                    temoTableEntity.setRemban8(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "9":
                    temoTableEntity.setRemban9(nullToEmpty(entity.getServiceJokyo()));
                    break;
                case "10":
                    temoTableEntity.setRemban10(nullToEmpty(entity.getServiceJokyo()));
                    break;
                default:
                    break;
            }
            項番編集(entity, temoTableEntity);
        } else {
            temoTableEntity = new NinteichosaJohoTempTableEntity();
            temoTableEntity.setShinseishoKanriNo(nullToEmpty(entity.getShinseishoKanriNo()));
            temoTableEntity.setKoroshoIfShikibetsuCode(nullToEmpty(entity.getKoroshoIfShikibetsuCode()));
            temoTableEntity.setRemban1(nullToEmpty(entity.getServiceJokyo()));
            サービスの状況一時リスト.add(temoTableEntity);
            map.put(申請書管理番号.toString(), nullToEmpty(entity.getShinseishoKanriNo()));
            map.put(厚労省IF識別コード.toString(), nullToEmpty(entity.getKoroshoIfShikibetsuCode()));
        }
        return temoTableEntity;
    }

    /**
     *
     * @param entity NinteichosahyoServiceJokyoRelateEntity
     * @param temoTableEntity NinteichosaJohoTempTableEntity
     * @param map Map<String, RString>
     * @param 調査調査項目リスト List<ChosaItemJohoTempTableEntity>
     * @return temoTableEntity ChosaItemJohoTempTableEntity
     */
    public ChosaItemJohoTempTableEntity get認定調査票基本調査(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity, Map<String, RString> map,
            List<ChosaItemJohoTempTableEntity> 調査調査項目リスト) {
        if (map.get(申請書管理番号.toString()).equals(entity.getShinseishoKanriNo())
                && map.get(厚労省IF識別コード.toString()).equals(entity.getKoroshoIfShikibetsuCode())) {
            switch (entity.getRemban().toString()) {
                case "2":
                    temoTableEntity.setRemban2(nullToEmpty(entity.getResearchItem()));
                    break;
                case "3":
                    temoTableEntity.setRemban3(nullToEmpty(entity.getResearchItem()));
                    break;
                case "4":
                    temoTableEntity.setRemban4(nullToEmpty(entity.getResearchItem()));
                    break;
                case "5":
                    temoTableEntity.setRemban5(nullToEmpty(entity.getResearchItem()));
                    break;
                case "6":
                    temoTableEntity.setRemban6(nullToEmpty(entity.getResearchItem()));
                    break;
                case "7":
                    temoTableEntity.setRemban7(nullToEmpty(entity.getResearchItem()));
                    break;
                case "8":
                    temoTableEntity.setRemban8(nullToEmpty(entity.getResearchItem()));
                    break;
                case "9":
                    temoTableEntity.setRemban9(nullToEmpty(entity.getResearchItem()));
                    break;
                case "10":
                    temoTableEntity.setRemban10(nullToEmpty(entity.getResearchItem()));
                    break;
                default:
                    break;
            }
            項番編集(entity, temoTableEntity);
            項番編集2(entity, temoTableEntity);
            項番編集3(entity, temoTableEntity);
            項番編集4(entity, temoTableEntity);
            項番編集5(entity, temoTableEntity);
            項番編集6(entity, temoTableEntity);
            項番編集7(entity, temoTableEntity);
            項番編集7(entity, temoTableEntity);
            項番編集8(entity, temoTableEntity);
        } else {
            if (new RString("1").equals(entity.getRemban())) {
                temoTableEntity = new ChosaItemJohoTempTableEntity();
                temoTableEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
                temoTableEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
                temoTableEntity.setRemban1(nullToEmpty(entity.getResearchItem()));
            }
            if (temoTableEntity != null) {
                調査調査項目リスト.add(temoTableEntity);
            }
            map.put(申請書管理番号.toString(), nullToEmpty(entity.getShinseishoKanriNo()));
            map.put(厚労省IF識別コード.toString(), nullToEmpty(entity.getKoroshoIfShikibetsuCode()));
        }
        return temoTableEntity;
    }

    /**
     *
     * @param entity NinteichosahyoServiceJokyoRelateEntity
     * @param temoTableEntity NinteichosaJohoTempTableEntity
     * @param map Map<String, RString>
     * @param 要介護認定主治医リスト List<ShujiiIkenshoJohoTempTableEntity>
     * @return temoTableEntity ShujiiIkenshoJohoTempTableEntity
     */
    public ShujiiIkenshoJohoTempTableEntity get要介護認定主治医意見(NinteichosahyoServiceJokyoRelateEntity entity,
            ShujiiIkenshoJohoTempTableEntity temoTableEntity, Map<String, RString> map,
            List<ShujiiIkenshoJohoTempTableEntity> 要介護認定主治医リスト) {
        if (map.get(申請書管理番号.toString()).equals(entity.getShinseishoKanriNo())
                && map.get(厚労省IF識別コード.toString()).equals(entity.getKoroshoIfShikibetsuCode())) {
            switch (entity.getRemban().toString()) {
                case "15":
                    temoTableEntity.setRemban15(nullToEmpty(entity.getIkenItem()));
                    break;
                case "16":
                    temoTableEntity.setRemban16(nullToEmpty(entity.getIkenItem()));
                    break;
                case "17":
                    temoTableEntity.setRemban17(nullToEmpty(entity.getIkenItem()));
                    break;
                case "18":
                    temoTableEntity.setRemban18(nullToEmpty(entity.getIkenItem()));
                    break;
                case "19":
                    temoTableEntity.setRemban19(nullToEmpty(entity.getIkenItem()));
                    break;
                case "69":
                    temoTableEntity.setRemban69(nullToEmpty(entity.getIkenItem()));
                    break;
                default:
                    break;
            }
        } else {
            if (new RString("14").equals(entity.getRemban())) {
                temoTableEntity = new ShujiiIkenshoJohoTempTableEntity();
                temoTableEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
                temoTableEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
                temoTableEntity.setRemban14(nullToEmpty(entity.getIkenItem()));

            }
            if (temoTableEntity != null) {
                要介護認定主治医リスト.add(temoTableEntity);
            }
            map.put(申請書管理番号.toString(), nullToEmpty(entity.getShinseishoKanriNo()));
            map.put(厚労省IF識別コード.toString(), nullToEmpty(entity.getKoroshoIfShikibetsuCode()));
        }
        return temoTableEntity;

    }

    /**
     * 出力件数を取得するメッソドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param paramter ShinchokuDataOutputProcessParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(IchijiHanteizumIfOutputProcessParamter paramter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【申請書管理番号リスト】"));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("("));
        List<ShinseishoKanriNo> shinseishoKanriNoList = paramter.getShinseishoKanriNoList();
        for (ShinseishoKanriNo shinseishoKanriNo : shinseishoKanriNoList) {
            jokenBuilder.append(shinseishoKanriNo);
            jokenBuilder.append(new RString(","));
        }
        jokenBuilder.append(new RString(")"));
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entity entity
     * @return NinteiChosaDataOutputEucCsvEntity
     */
    public IchijiHanteizumIfOutputEucCsvEntity setEucCsvEntity(IchijiHanteizumIfOutputRelateEntity entity) {
        IchijiHanteizumIfOutputEucCsvEntity eucEntity = new IchijiHanteizumIfOutputEucCsvEntity();
        RString 連番号 = new RString(Integer.toString(++項番));
        eucEntity.setシーケンシャル番号(連番号);
        eucEntity.set機能コード(RString.EMPTY);
        eucEntity.set識別コード(nullToEmpty(entity.getKoroshoIfShikibetsuCode()));
        eucEntity.set保険者番号(nullToEmpty(entity.getShoKisaiHokenshaNo()));
        eucEntity.set被保険者番号(nullToEmpty(entity.getHihokenshaNo()));
        eucEntity.set認定申請日(nullToEmpty(entity.getNinteiShinseiYMD()));
        eucEntity.set枝番(nullToEmpty(entity.getNinteiShinseiEdabanCode()));
        eucEntity.set申請区分法令コード(nullToEmpty(entity.getNinteiShinseiHoreiKubunCode()));
        eucEntity.set申請区分申請時コード(nullToEmpty(entity.getNinteiShinseiShinseijiKubunCode()));
        eucEntity.set取下区分コード(nullToEmpty(entity.getTorisageKubunCode()));
        eucEntity.set被保険者区分コード(nullToEmpty(entity.getHihokenshaKubunCode()));
        eucEntity.set申請代行区分コード(nullToEmpty(entity.getShinseiTodokedeDaikoKubunCode()));
        eucEntity.set生年月日(nullToEmpty(entity.getSeinengappiYMD()));
        eucEntity.set年齢(nullToEmpty(entity.getAge()));
        eucEntity.set性別コード(nullToEmpty(entity.getSeibetsu()));
        eucEntity.set被保険者ｶﾅ氏名(nullToEmpty(entity.getHihokenshaKana()));
        eucEntity.set被保険者漢字氏名(nullToEmpty(entity.getHihokenshaName()));
        eucEntity.set郵便番号(nullToEmpty(entity.getYubinNo()));
        eucEntity.set住所(nullToEmpty(entity.getJusho()));
        eucEntity.set電話番号(nullToEmpty(entity.getTelNo()));
        eucEntity.set病院施設等の名称(nullToEmpty(entity.getJigyoshaName()));
        eucEntity.set病院施設等の所在地(nullToEmpty(entity.getJigyoshaAddress()));
        eucEntity.set前回の認定審査会結果(nullToEmpty(entity.getZenYokaigoKubunCode()));
        認定申請区分(entity, eucEntity);
        eucEntity.set主治医医療機関番号(nullToEmpty(entity.getShujiiIryokikanCode()));
        eucEntity.set主治医番号(nullToEmpty(entity.getShujiiCode()));
        eucEntity.set意見書依頼日(nullToEmpty(entity.getIkenshoSakuseiIraiYMD()));
        eucEntity.set意見書入手日(nullToEmpty(entity.getIkenshoJuryoYMD()));
        eucEntity.set調査依頼日(nullToEmpty(entity.getNinteichosaIraiYMD()));
        eucEntity.set調査実施日(nullToEmpty(entity.getNinteichosaJisshiYMD()));
        eucEntity.set指定居宅介護支援事業者等番号(nullToEmpty(entity.getJigyoshaNo()));
        eucEntity.set委託区分(nullToEmpty(entity.getChosaItakuKubun()));
        eucEntity.set認定調査員番号(nullToEmpty(entity.getNinteiChosainCode()));
        eucEntity.set認定調査員資格コード(nullToEmpty(entity.getChosainShikaku()));
        eucEntity.set一次判定日(RString.EMPTY);
        eucEntity.set一次判定結果(RString.EMPTY);
        eucEntity.set一次判定結果認知症加算(RString.EMPTY);
        eucEntity.set要介護認定等基準時間(RString.EMPTY);
        eucEntity.set要介護認定等基準時間食事(RString.EMPTY);
        eucEntity.set要介護認定等基準時間排泄(RString.EMPTY);
        eucEntity.set要介護認定等基準時間移動(RString.EMPTY);
        eucEntity.set要介護認定等基準時間清潔保持(RString.EMPTY);
        eucEntity.set要介護認定等基準時間間接ケア(RString.EMPTY);
        eucEntity.set要介護認定等基準時間BPSD関連(RString.EMPTY);
        eucEntity.set要介護認定等基準時間機能訓練(RString.EMPTY);
        eucEntity.set要介護認定等基準時間医療関連(RString.EMPTY);
        eucEntity.set要介護認定等基準時間認知症加算(RString.EMPTY);
        eucEntity.set中間評価項目得点第１群(RString.EMPTY);
        eucEntity.set中間評価項目得点第２群(RString.EMPTY);
        eucEntity.set中間評価項目得点第３群(RString.EMPTY);
        eucEntity.set中間評価項目得点第４群(RString.EMPTY);
        eucEntity.set中間評価項目得点第５群(RString.EMPTY);
        eucEntity.set一次判定警告配列コード(RString.EMPTY);
        eucEntity.set状態の安定性(RString.EMPTY);
        eucEntity.set認知症自立度Ⅱ以上の蓋然性(RString.EMPTY);
        eucEntity.set認知機能及び状態安定性から推定される給付区分(RString.EMPTY);
        eucEntity.set認定審査会資料作成日(RString.EMPTY);
        eucEntity.set認定審査会予定日(RString.EMPTY);
        eucEntity.set合議体番号(RString.EMPTY);
        eucEntity.set審査会資料番号(RString.EMPTY);
        eucEntity.set二次判定日(RString.EMPTY);
        eucEntity.set二次判定結果(RString.EMPTY);
        eucEntity.set認定有効期間開始(RString.EMPTY);
        eucEntity.set認定有効期間終了(RString.EMPTY);
        eucEntity.set特定疾病コード(RString.EMPTY);
        eucEntity.set要介護１の場合の状態像(nullToEmpty(entity.getZenYokaigoKubunCode()));
        eucEntity.set現在のサービス区分コード(nullToEmpty(entity.getServiceKubunCode()));
        eucEntity.set現在の状況(nullToEmpty(entity.getRemban()));
        eucEntity.set訪問介護ホームヘルプサービス(nullToEmpty(entity.getサービスremban1()));
        eucEntity.set訪問入浴介護(nullToEmpty(entity.getサービスremban2()));
        eucEntity.set訪問看護(nullToEmpty(entity.getサービスremban3()));
        eucEntity.set訪問リハビリテーション(nullToEmpty(entity.getサービスremban4()));
        eucEntity.set居宅療養管理指導(nullToEmpty(entity.getサービスremban5()));
        eucEntity.set通所介護デイサービス(nullToEmpty(entity.getサービスremban6()));
        eucEntity.set通所リハビリテーション(nullToEmpty(entity.getサービスremban7()));
        eucEntity.set住宅改修介護給付(nullToEmpty(entity.getServiceJokyoFlag()));
        eucEntity.set介護予防訪問介護ホームヘルプサービス(nullToEmpty(entity.getサービスremban1()));
        eucEntity.set介護予防訪問入浴介護(nullToEmpty(entity.getサービスremban2()));
        eucEntity.set介護予防訪問看護(nullToEmpty(entity.getサービスremban3()));
        eucEntity.set介護予防訪問リハビリテーション(nullToEmpty(entity.getサービスremban4()));
        eucEntity.set介護予防居宅療養管理指導(nullToEmpty(entity.getサービスremban5()));
        eucEntity.set介護予防通所介護デイサービス(nullToEmpty(entity.getサービスremban6()));
        eucEntity.set介護予防通所リハビリテーション(nullToEmpty(entity.getサービスremban7()));
        eucEntity.set住宅改修予防給付(nullToEmpty(entity.getServiceJokyoFlag()));
        if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode())) {
            予防給付サービス(entity, eucEntity);
            前回予防給付サービス(entity, eucEntity);
        }
        eucEntity.set麻痺左上肢(nullToEmpty(entity.get認定調査remban1()));
        eucEntity.set麻痺右上肢(nullToEmpty(entity.get認定調査remban2()));
        eucEntity.set麻痺左下肢(nullToEmpty(entity.get認定調査remban3()));
        eucEntity.set麻痺右下肢(nullToEmpty(entity.get認定調査remban4()));
        eucEntity.set麻痺その他(nullToEmpty(entity.get認定調査remban5()));
        eucEntity.set拘縮肩関節(nullToEmpty(entity.get認定調査remban6()));
        eucEntity.set障害高齢者自立度(nullToEmpty(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        eucEntity.set認知症高齢者自立度(nullToEmpty(entity.getShogaiNichijoSeikatsuJiritsudoCode()));
        eucEntity.set前回結果_麻痺左上肢(nullToEmpty(entity.get前回認定remban1()));
        eucEntity.set前回結果_麻痺右上肢(nullToEmpty(entity.get前回認定remban2()));
        eucEntity.set前回結果_麻痺左下肢(nullToEmpty(entity.get前回認定remban3()));
        eucEntity.set前回結果_麻痺右下肢(nullToEmpty(entity.get前回認定remban4()));
        eucEntity.set前回結果_麻痺その他(nullToEmpty(entity.get前回認定remban5()));
        eucEntity.set前回結果_拘縮肩関節(nullToEmpty(entity.get前回認定remban6()));
        eucEntity.set前回結果_障害高齢者自立度(nullToEmpty(entity.get前回ninchishoNichijoSeikatsuJiritsudoCode()));
        eucEntity.set前回結果_認知症高齢者自立度(nullToEmpty(entity.get前回shogaiNichijoSeikatsuJiritsudoCode()));
        eucEntity.set前回結果_一次判定結果(nullToEmpty(entity.get前回ichijiHanteiKekkaCode()));
        eucEntity.set前回結果_一次判定結果認知症加算(nullToEmpty(entity.get前回ichijiHanteiKekkaNinchishoKasanCode()));
        eucEntity.set前回結果_要介護認定等基準時間(nullToEmpty(entity.get前回kijunJikan()));
        eucEntity.set前回結果_要介護認定等基準時間食事(nullToEmpty(entity.get前回kijunJikanShokuji()));
        eucEntity.set前回結果_要介護認定等基準時間排泄(nullToEmpty(entity.get前回kijunJikanHaisetsu()));
        eucEntity.set前回結果_要介護認定等基準時間移動(nullToEmpty(entity.get前回kijunJikanIdo()));
        eucEntity.set前回結果_要介護認定等基準時間清潔保持(nullToEmpty(entity.get前回kijunJikanSeiketsuHoji()));
        eucEntity.set前回結果_要介護認定等基準時間間接ケア(nullToEmpty(entity.get前回kijunJikanKansetsuCare()));
        eucEntity.set前回結果_要介護認定等基準時間BPSD_関連(nullToEmpty(entity.get前回kijunJikanBPSDKanren()));
        eucEntity.set前回結果_要介護認定等基準時間機能訓練(nullToEmpty(entity.get前回kijunJikanKinoKunren()));
        eucEntity.set前回結果_要介護認定等基準時間医療関連(nullToEmpty(entity.get前回kijunJikanIryoKanren()));
        eucEntity.set前回結果_要介護認定等基準時間認知症加算(nullToEmpty(entity.get前回kijunJikanNinchishoKasan()));
        eucEntity.set前回結果_中間評価項目得点_第１群(nullToEmpty(entity.get前回chukanHyokaKomoku1gun()));
        eucEntity.set前回結果_中間評価項目得点_第２群(nullToEmpty(entity.get前回chukanHyokaKomoku2gun()));
        eucEntity.set前回結果_中間評価項目得点_第３群(nullToEmpty(entity.get前回chukanHyokaKomoku3gun()));
        eucEntity.set前回結果_中間評価項目得点_第４群(nullToEmpty(entity.get前回chukanHyokaKomoku4gun()));
        eucEntity.set前回結果_中間評価項目得点_第５群(nullToEmpty(entity.get前回chukanHyokaKomoku5gun()));
        eucEntity.set前回結果_一次判定警告コード(nullToEmpty(entity.get前回ichijiHnateiKeikokuCode()));
        eucEntity.set前回結果_状態の安定性(nullToEmpty(entity.get前回jotaiAnteiseiCode()));
        eucEntity.set前回結果_認知症自立度Ⅱ以上の蓋然性(nullToEmpty(entity.get前回ninchishoJiritsudoIIijoNoGaizensei()));
        eucEntity.set前回結果_認知機能及び状態安定性から推定される給付区分(nullToEmpty(entity.get前回suiteiKyufuKubunCode()));
        eucEntity.set前回結果_申請日(nullToEmpty(entity.get前回ninteiShinseiYMD()));
        eucEntity.set前回結果_二次判定日(nullToEmpty(entity.get前回nijiHanteiYMD()));
        eucEntity.set前回結果_現在のサービス区分コード(nullToEmpty(entity.get前回serviceKubunCode()));
        eucEntity.set前回結果_現在の状況(nullToEmpty(entity.getPo2remban()));
        eucEntity.set前回結果_訪問介護ホームヘルプサービス(nullToEmpty(entity.get前回サービスremban1()));
        eucEntity.set前回結果_訪問入浴介護(nullToEmpty(entity.get前回サービスremban2()));
        eucEntity.set前回結果_訪問看護(nullToEmpty(entity.get前回サービスremban3()));
        eucEntity.set前回結果_訪問リハビリテーション(nullToEmpty(entity.get前回サービスremban4()));
        eucEntity.set前回結果_居宅療養管理指導(nullToEmpty(entity.get前回サービスremban5()));
        eucEntity.set前回結果_通所介護デイサービス(nullToEmpty(entity.get前回サービスremban6()));
        eucEntity.set前回結果_通所リハビリテーション(nullToEmpty(entity.get前回サービスremban7()));
        eucEntity.set前回識別コード(nullToEmpty(entity.get前回koroshoIfShikibetsuCode()));
        eucEntity.set認定審査会意見等(RString.EMPTY);
        eucEntity.setコメント等(nullToEmpty(entity.get前回shinsakaiMemo()));
        認定調査票時テーブル(entity, eucEntity);
        前回認定調査票時テーブル(entity, eucEntity);
        return eucEntity;

    }

    private void 認定申請区分(IchijiHanteizumIfOutputRelateEntity entity, IchijiHanteizumIfOutputEucCsvEntity eucEntity) {
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode())) {
            eucEntity.set前回の認定有効期間開始(nullToEmpty(entity.getZenkaiYukoKikanStart()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode())
                && NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode())) {
            eucEntity.set前回の認定有効期間終了(nullToEmpty(entity.getZenkaiYukoKikanEnd()));
        }
    }

    private void 認定調査票時テーブル(IchijiHanteizumIfOutputRelateEntity entity, IchijiHanteizumIfOutputEucCsvEntity eucEntity) {
        if (entity.getKoroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_99A.equals(entity.getKoroshoIfShikibetsuCode())
                || (厚労省IF識別コード_02A.equals(entity.getKoroshoIfShikibetsuCode()))
                || (厚労省IF識別コード_06A.equals(entity.getKoroshoIfShikibetsuCode())))) {
            eucEntity.set拘縮股関節(nullToEmpty(entity.get認定調査remban8()));
            eucEntity.set拘縮膝関節(nullToEmpty(entity.get認定調査remban9()));
            eucEntity.set拘縮その他(nullToEmpty(entity.get認定調査remban11()));
            eucEntity.set寝返り(nullToEmpty(entity.get認定調査remban12()));
            eucEntity.set起き上がり(nullToEmpty(entity.get認定調査remban13()));
            eucEntity.set座位保持(nullToEmpty(entity.get認定調査remban14()));
            eucEntity.set立ち上がり(nullToEmpty(entity.get認定調査remban19()));
            eucEntity.set片足での立位(nullToEmpty(entity.get認定調査remban20()));
            eucEntity.set独り言独り笑い(nullToEmpty(entity.get認定調査remban54()));
            eucEntity.set自分勝手に行動する(nullToEmpty(entity.get認定調査remban55()));
            eucEntity.set話がまとまらない(nullToEmpty(entity.get認定調査remban56()));
            eucEntity.set集団への不適応(RString.EMPTY);
            eucEntity.set買い物(RString.EMPTY);
            eucEntity.set簡単な調理(RString.EMPTY);
        } else {
            eucEntity.set拘縮股関節(nullToEmpty(entity.get認定調査remban7()));
            eucEntity.set拘縮膝関節(nullToEmpty(entity.get認定調査remban8()));
            eucEntity.set拘縮その他(nullToEmpty(entity.get認定調査remban9()));
            eucEntity.set寝返り(nullToEmpty(entity.get認定調査remban10()));
            eucEntity.set起き上がり(nullToEmpty(entity.get認定調査remban11()));
            eucEntity.set座位保持(nullToEmpty(entity.get認定調査remban12()));
            eucEntity.set立ち上がり(nullToEmpty(entity.get認定調査remban15()));
            eucEntity.set片足での立位(nullToEmpty(entity.get認定調査remban16()));
            eucEntity.set独り言独り笑い(RString.EMPTY);
            eucEntity.set自分勝手に行動する(RString.EMPTY);
            eucEntity.set話がまとまらない(RString.EMPTY);
            eucEntity.set集団への不適応(nullToEmpty(entity.get認定調査remban60()));
            eucEntity.set買い物(nullToEmpty(entity.get認定調査remban61()));
            eucEntity.set簡単な調理(nullToEmpty(entity.get認定調査remban62()));

        }
        if (entity.getKoroshoIfShikibetsuCode() != null
                && 厚労省IF識別コード_99A.equals(entity.getKoroshoIfShikibetsuCode())) {
            eucEntity.set両足での立位(nullToEmpty(entity.get認定調査remban16()));
            eucEntity.set歩行(nullToEmpty(entity.get認定調査remban17()));
            eucEntity.set洗身(nullToEmpty(entity.get認定調査remban22()));
            eucEntity.setつめ切り(nullToEmpty(entity.get認定調査remban35()));
            eucEntity.set視力(nullToEmpty(entity.get認定調査remban45()));
            eucEntity.set聴力(nullToEmpty(entity.get認定調査remban46()));
            eucEntity.set移乗(nullToEmpty(entity.get認定調査remban18()));
            eucEntity.set移動(RString.EMPTY);
            eucEntity.setえん下(nullToEmpty(entity.get認定調査remban26()));
            eucEntity.set食事摂取(nullToEmpty(entity.get認定調査remban31()));
            eucEntity.set排尿(RString.EMPTY);
            eucEntity.set排便(RString.EMPTY);
            eucEntity.set口腔清潔(nullToEmpty(entity.get認定調査remban32()));
            eucEntity.set洗顔(nullToEmpty(entity.get認定調査remban33()));
            eucEntity.set整髪(nullToEmpty(entity.get認定調査remban34()));
            eucEntity.set上衣の着脱(nullToEmpty(entity.get認定調査remban37()));
            eucEntity.setズボン等の着脱(nullToEmpty(entity.get認定調査remban38()));
            eucEntity.set外出頻度(RString.EMPTY);
            eucEntity.set意思の伝達(nullToEmpty(entity.get認定調査remban47()));
            eucEntity.set毎日の日課を理解(nullToEmpty(entity.get認定調査remban49()));
            eucEntity.set生年月日をいう(nullToEmpty(entity.get認定調査remban50()));
            eucEntity.set短期記憶(nullToEmpty(entity.get認定調査remban51()));
            eucEntity.set自分の名前をいう(nullToEmpty(entity.get認定調査remban52()));
            eucEntity.set今の季節を理解(nullToEmpty(entity.get認定調査remban53()));
            eucEntity.set場所の理解(nullToEmpty(entity.get認定調査remban54()));
            eucEntity.set徘徊(nullToEmpty(entity.get認定調査remban64()));
            eucEntity.set外出して戻れない(nullToEmpty(entity.get認定調査remban66()));
            eucEntity.set被害的(nullToEmpty(entity.get認定調査remban55()));
            eucEntity.set作話(nullToEmpty(entity.get認定調査remban56()));
            eucEntity.set感情が不安定(nullToEmpty(entity.get認定調査remban58()));
            eucEntity.set昼夜逆転(nullToEmpty(entity.get認定調査remban59()));
            eucEntity.set同じ話をする(nullToEmpty(entity.get認定調査remban61()));
            eucEntity.set大声を出す(nullToEmpty(entity.get認定調査remban62()));
            eucEntity.set介護に抵抗(nullToEmpty(entity.get認定調査remban63()));
            eucEntity.set落ち着きなし(nullToEmpty(entity.get認定調査remban65()));
            eucEntity.set一人で出たがる(nullToEmpty(entity.get認定調査remban67()));
            eucEntity.set収集癖(nullToEmpty(entity.get認定調査remban68()));
            eucEntity.set物や衣類を壊す(nullToEmpty(entity.get認定調査remban70()));
            eucEntity.setひどい物忘れ(nullToEmpty(entity.get認定調査remban43()));
            eucEntity.set薬の内服(nullToEmpty(entity.get認定調査remban41()));
            eucEntity.set金銭の管理(nullToEmpty(entity.get認定調査remban42()));
            eucEntity.set日常の意思決定(RString.EMPTY);
            eucEntity.set点滴の管理(nullToEmpty(entity.get認定調査remban74()));
            eucEntity.set中心静脈栄養(nullToEmpty(entity.get認定調査remban75()));
            eucEntity.set透析(nullToEmpty(entity.get認定調査remban76()));
            eucEntity.setストーマの処置(nullToEmpty(entity.get認定調査remban77()));
            eucEntity.set酸素療法(nullToEmpty(entity.get認定調査remban78()));
            eucEntity.setレスピレーター(nullToEmpty(entity.get認定調査remban79()));
            eucEntity.set気管切開の処置(nullToEmpty(entity.get認定調査remban80()));
            eucEntity.set疼痛の看護(nullToEmpty(entity.get認定調査remban81()));
            eucEntity.set経管栄養(nullToEmpty(entity.get認定調査remban82()));
            eucEntity.setモニター測定(nullToEmpty(entity.get認定調査remban83()));
            eucEntity.setじょくそうの処置(nullToEmpty(entity.get認定調査remban84()));
            eucEntity.setカテーテル(nullToEmpty(entity.get認定調査remban85()));
        }
        set認定調査票(entity, eucEntity);
    }

    private void set認定調査票(IchijiHanteizumIfOutputRelateEntity entity, IchijiHanteizumIfOutputEucCsvEntity eucEntity) {
        if (entity.getKoroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_02A.equals(entity.getKoroshoIfShikibetsuCode())
                || (厚労省IF識別コード_06A.equals(entity.getKoroshoIfShikibetsuCode())))) {
            eucEntity.set両足での立位(nullToEmpty(entity.get認定調査remban15()));
            eucEntity.set歩行(nullToEmpty(entity.get認定調査remban16()));
            eucEntity.set洗身(nullToEmpty(entity.get認定調査remban21()));
            eucEntity.setつめ切り(nullToEmpty(entity.get認定調査remban32()));
            eucEntity.set視力(nullToEmpty(entity.get認定調査remban39()));
            eucEntity.set聴力(nullToEmpty(entity.get認定調査remban40()));
            eucEntity.set移乗(nullToEmpty(entity.get認定調査remban17()));
            eucEntity.set移動(nullToEmpty(entity.get認定調査remban18()));
            eucEntity.setえん下(nullToEmpty(entity.get認定調査remban24()));
            eucEntity.set食事摂取(nullToEmpty(entity.get認定調査remban25()));
            eucEntity.set排尿(nullToEmpty(entity.get認定調査remban27()));
            eucEntity.set排便(nullToEmpty(entity.get認定調査remban28()));
            eucEntity.set口腔清潔(nullToEmpty(entity.get認定調査remban29()));
            eucEntity.set洗顔(nullToEmpty(entity.get認定調査remban30()));
            eucEntity.set整髪(nullToEmpty(entity.get認定調査remban31()));
            eucEntity.set上衣の着脱(nullToEmpty(entity.get認定調査remban33()));
            eucEntity.setズボン等の着脱(nullToEmpty(entity.get認定調査remban34()));
            eucEntity.set外出頻度(nullToEmpty(entity.get認定調査remban81()));
            eucEntity.set意思の伝達(nullToEmpty(entity.get認定調査remban41()));
            eucEntity.set毎日の日課を理解(nullToEmpty(entity.get認定調査remban43()));
            eucEntity.set生年月日をいう(nullToEmpty(entity.get認定調査remban44()));
            eucEntity.set短期記憶(nullToEmpty(entity.get認定調査remban45()));
            eucEntity.set自分の名前をいう(nullToEmpty(entity.get認定調査remban46()));
            eucEntity.set今の季節を理解(nullToEmpty(entity.get認定調査remban47()));
            eucEntity.set場所の理解(nullToEmpty(entity.get認定調査remban48()));
            eucEntity.set徘徊(nullToEmpty(entity.get認定調査remban58()));
            eucEntity.set外出して戻れない(nullToEmpty(entity.get認定調査remban60()));
            eucEntity.set被害的(nullToEmpty(entity.get認定調査remban49()));
            eucEntity.set作話(nullToEmpty(entity.get認定調査remban50()));
            eucEntity.set感情が不安定(nullToEmpty(entity.get認定調査remban52()));
            eucEntity.set昼夜逆転(nullToEmpty(entity.get認定調査remban53()));
            eucEntity.set同じ話をする(nullToEmpty(entity.get認定調査remban55()));
            eucEntity.set大声を出す(nullToEmpty(entity.get認定調査remban56()));
            eucEntity.set介護に抵抗(nullToEmpty(entity.get認定調査remban57()));
            eucEntity.set落ち着きなし(nullToEmpty(entity.get認定調査remban59()));
            eucEntity.set一人で出たがる(nullToEmpty(entity.get認定調査remban61()));
            eucEntity.set収集癖(nullToEmpty(entity.get認定調査remban62()));
            eucEntity.set物や衣類を壊す(nullToEmpty(entity.get認定調査remban64()));
            eucEntity.setひどい物忘れ(nullToEmpty(entity.get認定調査remban67()));
            eucEntity.set薬の内服(nullToEmpty(entity.get認定調査remban35()));
            eucEntity.set金銭の管理(nullToEmpty(entity.get認定調査remban36()));
            eucEntity.set日常の意思決定(nullToEmpty(entity.get認定調査remban38()));
            eucEntity.set点滴の管理(nullToEmpty(entity.get認定調査remban68()));
            eucEntity.set中心静脈栄養(nullToEmpty(entity.get認定調査remban69()));
            eucEntity.set透析(nullToEmpty(entity.get認定調査remban70()));
            eucEntity.setストーマの処置(nullToEmpty(entity.get認定調査remban71()));
            eucEntity.set酸素療法(nullToEmpty(entity.get認定調査remban72()));
            eucEntity.setレスピレーター(nullToEmpty(entity.get認定調査remban73()));
            eucEntity.set気管切開の処置(nullToEmpty(entity.get認定調査remban74()));
            eucEntity.set疼痛の看護(nullToEmpty(entity.get認定調査remban75()));
            eucEntity.set経管栄養(nullToEmpty(entity.get認定調査remban76()));
            eucEntity.setモニター測定(nullToEmpty(entity.get認定調査remban77()));
            eucEntity.setじょくそうの処置(nullToEmpty(entity.get認定調査remban78()));
            eucEntity.setカテーテル(nullToEmpty(entity.get認定調査remban79()));

        }
        if (entity.getKoroshoIfShikibetsuCode() != null
                && !(厚労省IF識別コード_99A.equals(entity.getKoroshoIfShikibetsuCode())
                && !(厚労省IF識別コード_02A.equals(entity.getKoroshoIfShikibetsuCode())
                && !(厚労省IF識別コード_06A.equals(entity.getKoroshoIfShikibetsuCode()))))) {
            eucEntity.set両足での立位(nullToEmpty(entity.get認定調査remban13()));
            eucEntity.set歩行(nullToEmpty(entity.get認定調査remban14()));
            eucEntity.set洗身(nullToEmpty(entity.get認定調査remban17()));
            eucEntity.setつめ切り(nullToEmpty(entity.get認定調査remban18()));
            eucEntity.set視力(nullToEmpty(entity.get認定調査remban19()));
            eucEntity.set聴力(nullToEmpty(entity.get認定調査remban20()));
            eucEntity.set移乗(nullToEmpty(entity.get認定調査remban21()));
            eucEntity.set移動(nullToEmpty(entity.get認定調査remban22()));
            eucEntity.setえん下(nullToEmpty(entity.get認定調査remban23()));
            eucEntity.set食事摂取(nullToEmpty(entity.get認定調査remban31()));
            eucEntity.set排尿(nullToEmpty(entity.get認定調査remban25()));
            eucEntity.set排便(nullToEmpty(entity.get認定調査remban26()));
            eucEntity.set口腔清潔(nullToEmpty(entity.get認定調査remban27()));
            eucEntity.set洗顔(nullToEmpty(entity.get認定調査remban28()));
            eucEntity.set整髪(nullToEmpty(entity.get認定調査remban29()));
            eucEntity.set上衣の着脱(nullToEmpty(entity.get認定調査remban30()));
            eucEntity.setズボン等の着脱(nullToEmpty(entity.get認定調査remban31()));
            eucEntity.set外出頻度(nullToEmpty(entity.get認定調査remban32()));
            eucEntity.set意思の伝達(nullToEmpty(entity.get認定調査remban33()));
            eucEntity.set毎日の日課を理解(nullToEmpty(entity.get認定調査remban34()));
            eucEntity.set生年月日をいう(nullToEmpty(entity.get認定調査remban35()));
            eucEntity.set短期記憶(nullToEmpty(entity.get認定調査remban36()));
            eucEntity.set自分の名前をいう(nullToEmpty(entity.get認定調査remban37()));
            eucEntity.set今の季節を理解(nullToEmpty(entity.get認定調査remban38()));
            eucEntity.set場所の理解(nullToEmpty(entity.get認定調査remban39()));
            eucEntity.set徘徊(nullToEmpty(entity.get認定調査remban40()));
            eucEntity.set外出して戻れない(nullToEmpty(entity.get認定調査remban41()));
            eucEntity.set被害的(nullToEmpty(entity.get認定調査remban42()));
            eucEntity.set作話(nullToEmpty(entity.get認定調査remban43()));
            eucEntity.set感情が不安定(nullToEmpty(entity.get認定調査remban44()));
            eucEntity.set昼夜逆転(nullToEmpty(entity.get認定調査remban45()));
            eucEntity.set同じ話をする(nullToEmpty(entity.get認定調査remban46()));
            eucEntity.set大声を出す(nullToEmpty(entity.get認定調査remban47()));
            eucEntity.set介護に抵抗(nullToEmpty(entity.get認定調査remban48()));
            eucEntity.set落ち着きなし(nullToEmpty(entity.get認定調査remban49()));
            eucEntity.set一人で出たがる(nullToEmpty(entity.get認定調査remban50()));
            eucEntity.set収集癖(nullToEmpty(entity.get認定調査remban51()));
            eucEntity.set物や衣類を壊す(nullToEmpty(entity.get認定調査remban52()));
            eucEntity.setひどい物忘れ(nullToEmpty(entity.get認定調査remban53()));
            eucEntity.set薬の内服(nullToEmpty(entity.get認定調査remban57()));
            eucEntity.set金銭の管理(nullToEmpty(entity.get認定調査remban58()));
            eucEntity.set日常の意思決定(nullToEmpty(entity.get認定調査remban59()));
            eucEntity.set点滴の管理(nullToEmpty(entity.get認定調査remban63()));
            eucEntity.set中心静脈栄養(nullToEmpty(entity.get認定調査remban64()));
            eucEntity.set透析(nullToEmpty(entity.get認定調査remban65()));
            eucEntity.setストーマの処置(nullToEmpty(entity.get認定調査remban66()));
            eucEntity.set酸素療法(nullToEmpty(entity.get認定調査remban67()));
            eucEntity.setレスピレーター(nullToEmpty(entity.get認定調査remban68()));
            eucEntity.set気管切開の処置(nullToEmpty(entity.get認定調査remban69()));
            eucEntity.set疼痛の看護(nullToEmpty(entity.get認定調査remban70()));
            eucEntity.set経管栄養(nullToEmpty(entity.get認定調査remban71()));
            eucEntity.setモニター測定(nullToEmpty(entity.get認定調査remban72()));
            eucEntity.setじょくそうの処置(nullToEmpty(entity.get認定調査remban73()));
            eucEntity.setカテーテル(nullToEmpty(entity.get認定調査remban74()));
        }
    }

    private void 前回認定調査票時テーブル(IchijiHanteizumIfOutputRelateEntity entity, IchijiHanteizumIfOutputEucCsvEntity eucEntity) {
        if (entity.get前回koroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_99A.equals(entity.get前回koroshoIfShikibetsuCode())
                || (厚労省IF識別コード_02A.equals(entity.get前回koroshoIfShikibetsuCode()))
                || (厚労省IF識別コード_06A.equals(entity.get前回koroshoIfShikibetsuCode())))) {
            eucEntity.set前回結果_拘縮股関節(nullToEmpty(entity.get前回認定remban8()));
            eucEntity.set前回結果_拘縮膝関節(nullToEmpty(entity.get前回認定remban9()));
            eucEntity.set前回結果_拘縮その他(nullToEmpty(entity.get前回認定remban11()));
            eucEntity.set前回結果_寝返り(nullToEmpty(entity.get前回認定remban12()));
            eucEntity.set前回結果_起き上がり(nullToEmpty(entity.get前回認定remban13()));
            eucEntity.set前回結果_座位保持(nullToEmpty(entity.get前回認定remban14()));
            eucEntity.set前回結果_立ち上がり(nullToEmpty(entity.get前回認定remban19()));
            eucEntity.set前回結果_片足での立位(nullToEmpty(entity.get前回認定remban20()));
            eucEntity.set前回結果_独り言独り笑い(nullToEmpty(entity.get前回認定remban54()));
            eucEntity.set前回結果_自分勝手に行動する(nullToEmpty(entity.get前回認定remban55()));
            eucEntity.set前回結果_話がまとまらない(nullToEmpty(entity.get前回認定remban56()));
            eucEntity.set前回結果_集団への不適応(RString.EMPTY);
            eucEntity.set前回結果_買い物(RString.EMPTY);
            eucEntity.set簡単な調理(RString.EMPTY);
        } else {
            eucEntity.set前回結果_拘縮股関節(nullToEmpty(entity.get前回認定remban7()));
            eucEntity.set前回結果_拘縮膝関節(nullToEmpty(entity.get前回認定remban8()));
            eucEntity.set前回結果_拘縮その他(nullToEmpty(entity.get前回認定remban9()));
            eucEntity.set前回結果_寝返り(nullToEmpty(entity.get前回認定remban10()));
            eucEntity.set前回結果_起き上がり(nullToEmpty(entity.get前回認定remban11()));
            eucEntity.set前回結果_座位保持(nullToEmpty(entity.get前回認定remban12()));
            eucEntity.set前回結果_立ち上がり(nullToEmpty(entity.get前回認定remban15()));
            eucEntity.set前回結果_片足での立位(nullToEmpty(entity.get前回認定remban16()));
            eucEntity.set前回結果_独り言独り笑い(RString.EMPTY);
            eucEntity.set前回結果_自分勝手に行動する(RString.EMPTY);
            eucEntity.set前回結果_話がまとまらない(RString.EMPTY);
            eucEntity.set前回結果_集団への不適応(nullToEmpty(entity.get前回認定remban60()));
            eucEntity.set前回結果_買い物(nullToEmpty(entity.get前回認定remban61()));
            eucEntity.set前回結果_簡単な調理(nullToEmpty(entity.get前回認定remban62()));

        }
        if (entity.get前回koroshoIfShikibetsuCode() != null
                && 厚労省IF識別コード_99A.equals(entity.get前回koroshoIfShikibetsuCode())) {
            eucEntity.set前回結果_両足での立位(nullToEmpty(entity.get前回認定remban16()));
            eucEntity.set前回結果_歩行(nullToEmpty(entity.get前回認定remban17()));
            eucEntity.set前回結果_洗身(nullToEmpty(entity.get前回認定remban22()));
            eucEntity.set前回結果_つめ切り(nullToEmpty(entity.get前回認定remban35()));
            eucEntity.set前回結果_視力(nullToEmpty(entity.get前回認定remban45()));
            eucEntity.set前回結果_聴力(nullToEmpty(entity.get前回認定remban46()));
            eucEntity.set前回結果_移乗(nullToEmpty(entity.get前回認定remban18()));
            eucEntity.set前回結果_移動(RString.EMPTY);
            eucEntity.set前回結果_えん下(nullToEmpty(entity.get前回認定remban26()));
            eucEntity.set前回結果_食事摂取(nullToEmpty(entity.get前回認定remban31()));
            eucEntity.set前回結果_排尿(RString.EMPTY);
            eucEntity.set前回結果_排便(RString.EMPTY);
            eucEntity.set前回結果_口腔清潔(nullToEmpty(entity.get前回認定remban32()));
            eucEntity.set前回結果_洗顔(nullToEmpty(entity.get前回認定remban33()));
            eucEntity.set前回結果_整髪(nullToEmpty(entity.get前回認定remban34()));
            eucEntity.set前回結果_上衣の着脱(nullToEmpty(entity.get前回認定remban37()));
            eucEntity.set前回結果_ズボン等の着脱(nullToEmpty(entity.get前回認定remban38()));
            eucEntity.set前回結果_外出頻度(RString.EMPTY);
            eucEntity.set前回結果_意思の伝達(nullToEmpty(entity.get前回認定remban47()));
            eucEntity.set前回結果_毎日の日課を理解(nullToEmpty(entity.get前回認定remban49()));
            eucEntity.set前回結果_生年月日をいう(nullToEmpty(entity.get前回認定remban50()));
            eucEntity.set前回結果_短期記憶(nullToEmpty(entity.get前回認定remban51()));
            eucEntity.set前回結果_自分の名前をいう(nullToEmpty(entity.get前回認定remban52()));
            eucEntity.set前回結果_今の季節を理解(nullToEmpty(entity.get前回認定remban53()));
            eucEntity.set前回結果_場所の理解(nullToEmpty(entity.get前回認定remban54()));
            eucEntity.set前回結果_徘徊(nullToEmpty(entity.get前回認定remban64()));
            eucEntity.set前回結果_外出して戻れない(nullToEmpty(entity.get前回認定remban66()));
            eucEntity.set前回結果_被害的(nullToEmpty(entity.get前回認定remban55()));
            eucEntity.set前回結果_作話(nullToEmpty(entity.get前回認定remban56()));
            eucEntity.set前回結果_感情が不安定(nullToEmpty(entity.get前回認定remban58()));
            eucEntity.set前回結果_昼夜逆転(nullToEmpty(entity.get前回認定remban59()));
            eucEntity.set前回結果_同じ話をする(nullToEmpty(entity.get前回認定remban61()));
            eucEntity.set前回結果_大声を出す(nullToEmpty(entity.get前回認定remban62()));
            eucEntity.set前回結果_介護に抵抗(nullToEmpty(entity.get前回認定remban63()));
            eucEntity.set前回結果_落ち着きなし(nullToEmpty(entity.get前回認定remban65()));
            eucEntity.set前回結果_一人で出たがる(nullToEmpty(entity.get前回認定remban67()));
            eucEntity.set前回結果_収集癖(nullToEmpty(entity.get前回認定remban68()));
            eucEntity.set前回結果_物や衣類を壊す(nullToEmpty(entity.get前回認定remban70()));
            eucEntity.set前回結果_ひどい物忘れ(nullToEmpty(entity.get前回認定remban43()));
            eucEntity.set前回結果_薬の内服(nullToEmpty(entity.get前回認定remban41()));
            eucEntity.set前回結果_金銭の管理(nullToEmpty(entity.get前回認定remban42()));
            eucEntity.set前回結果_日常の意思決定(RString.EMPTY);
            eucEntity.set前回結果_点滴の管理(nullToEmpty(entity.get前回認定remban74()));
            eucEntity.set前回結果_中心静脈栄養(nullToEmpty(entity.get前回認定remban75()));
            eucEntity.set前回結果_透析(nullToEmpty(entity.get前回認定remban76()));
            eucEntity.set前回結果_ストーマの処置(nullToEmpty(entity.get前回認定remban77()));
            eucEntity.set前回結果_酸素療法(nullToEmpty(entity.get前回認定remban78()));
            eucEntity.set前回結果_レスピレーター(nullToEmpty(entity.get前回認定remban79()));
            eucEntity.set前回結果_気管切開の処置(nullToEmpty(entity.get前回認定remban80()));
            eucEntity.set前回結果_疼痛の看護(nullToEmpty(entity.get前回認定remban81()));
            eucEntity.set前回結果_経管栄養(nullToEmpty(entity.get前回認定remban82()));
            eucEntity.set前回結果_モニター測定(nullToEmpty(entity.get前回認定remban83()));
            eucEntity.set前回結果_じょくそうの処置(nullToEmpty(entity.get前回認定remban84()));
            eucEntity.set前回結果_カテーテル(nullToEmpty(entity.get前回認定remban85()));
        }
        set前回結果(entity, eucEntity);
    }

    private void set前回結果(IchijiHanteizumIfOutputRelateEntity entity, IchijiHanteizumIfOutputEucCsvEntity eucEntity) {
        if (entity.get前回koroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_02A.equals(entity.get前回koroshoIfShikibetsuCode())
                || (厚労省IF識別コード_06A.equals(entity.get前回koroshoIfShikibetsuCode())))) {
            eucEntity.set前回結果_両足での立位(nullToEmpty(entity.get前回認定remban15()));
            eucEntity.set前回結果_歩行(nullToEmpty(entity.get前回認定remban16()));
            eucEntity.set前回結果_洗身(nullToEmpty(entity.get前回認定remban21()));
            eucEntity.set前回結果_つめ切り(nullToEmpty(entity.get前回認定remban32()));
            eucEntity.set前回結果_視力(nullToEmpty(entity.get前回認定remban39()));
            eucEntity.set前回結果_聴力(nullToEmpty(entity.get前回認定remban40()));
            eucEntity.set前回結果_移乗(nullToEmpty(entity.get前回認定remban17()));
            eucEntity.set前回結果_移動(nullToEmpty(entity.get前回認定remban18()));
            eucEntity.set前回結果_えん下(nullToEmpty(entity.get前回認定remban24()));
            eucEntity.set前回結果_食事摂取(nullToEmpty(entity.get前回認定remban25()));
            eucEntity.set前回結果_排尿(nullToEmpty(entity.get前回認定remban27()));
            eucEntity.set前回結果_排便(nullToEmpty(entity.get前回認定remban28()));
            eucEntity.set前回結果_口腔清潔(nullToEmpty(entity.get前回認定remban29()));
            eucEntity.set前回結果_洗顔(nullToEmpty(entity.get前回認定remban30()));
            eucEntity.set前回結果_整髪(nullToEmpty(entity.get前回認定remban31()));
            eucEntity.set前回結果_上衣の着脱(nullToEmpty(entity.get前回認定remban33()));
            eucEntity.set前回結果_ズボン等の着脱(nullToEmpty(entity.get前回認定remban34()));
            eucEntity.set前回結果_外出頻度(nullToEmpty(entity.get前回認定remban81()));
            eucEntity.set前回結果_意思の伝達(nullToEmpty(entity.get前回認定remban41()));
            eucEntity.set前回結果_毎日の日課を理解(nullToEmpty(entity.get前回認定remban43()));
            eucEntity.set前回結果_生年月日をいう(nullToEmpty(entity.get前回認定remban44()));
            eucEntity.set前回結果_短期記憶(nullToEmpty(entity.get前回認定remban45()));
            eucEntity.set前回結果_自分の名前をいう(nullToEmpty(entity.get前回認定remban46()));
            eucEntity.set前回結果_今の季節を理解(nullToEmpty(entity.get前回認定remban47()));
            eucEntity.set前回結果_場所の理解(nullToEmpty(entity.get前回認定remban48()));
            eucEntity.set前回結果_徘徊(nullToEmpty(entity.get前回認定remban58()));
            eucEntity.set前回結果_外出して戻れない(nullToEmpty(entity.get前回認定remban60()));
            eucEntity.set前回結果_被害的(nullToEmpty(entity.get前回認定remban49()));
            eucEntity.set前回結果_作話(nullToEmpty(entity.get前回認定remban50()));
            eucEntity.set前回結果_感情が不安定(nullToEmpty(entity.get前回認定remban52()));
            eucEntity.set前回結果_昼夜逆転(nullToEmpty(entity.get前回認定remban53()));
            eucEntity.set前回結果_同じ話をする(nullToEmpty(entity.get前回認定remban55()));
            eucEntity.set前回結果_大声を出す(nullToEmpty(entity.get前回認定remban56()));
            eucEntity.set前回結果_介護に抵抗(nullToEmpty(entity.get前回認定remban57()));
            eucEntity.set前回結果_落ち着きなし(nullToEmpty(entity.get前回認定remban59()));
            eucEntity.set前回結果_一人で出たがる(nullToEmpty(entity.get前回認定remban61()));
            eucEntity.set前回結果_収集癖(nullToEmpty(entity.get前回認定remban62()));
            eucEntity.set前回結果_物や衣類を壊す(nullToEmpty(entity.get前回認定remban64()));
            eucEntity.set前回結果_ひどい物忘れ(nullToEmpty(entity.get前回認定remban67()));
            eucEntity.set前回結果_薬の内服(nullToEmpty(entity.get前回認定remban35()));
            eucEntity.set前回結果_金銭の管理(nullToEmpty(entity.get前回認定remban36()));
            eucEntity.set前回結果_日常の意思決定(nullToEmpty(entity.get前回認定remban38()));
            eucEntity.set前回結果_点滴の管理(nullToEmpty(entity.get前回認定remban68()));
            eucEntity.set前回結果_中心静脈栄養(nullToEmpty(entity.get前回認定remban69()));
            eucEntity.set前回結果_透析(nullToEmpty(entity.get前回認定remban70()));
            eucEntity.set前回結果_ストーマの処置(nullToEmpty(entity.get前回認定remban71()));
            eucEntity.set前回結果_酸素療法(nullToEmpty(entity.get前回認定remban72()));
            eucEntity.set前回結果_レスピレーター(nullToEmpty(entity.get前回認定remban73()));
            eucEntity.set前回結果_気管切開の処置(nullToEmpty(entity.get前回認定remban74()));
            eucEntity.set前回結果_疼痛の看護(nullToEmpty(entity.get前回認定remban75()));
            eucEntity.set前回結果_経管栄養(nullToEmpty(entity.get前回認定remban76()));
            eucEntity.set前回結果_モニター測定(nullToEmpty(entity.get前回認定remban77()));
            eucEntity.set前回結果_じょくそうの処置(nullToEmpty(entity.get前回認定remban78()));
            eucEntity.set前回結果_カテーテル(nullToEmpty(entity.get前回認定remban79()));
        }
        if (entity.get前回koroshoIfShikibetsuCode() != null
                && !(厚労省IF識別コード_99A.equals(entity.get前回koroshoIfShikibetsuCode())
                && !(厚労省IF識別コード_02A.equals(entity.get前回koroshoIfShikibetsuCode())
                && !(厚労省IF識別コード_06A.equals(entity.get前回koroshoIfShikibetsuCode()))))) {
            eucEntity.set前回結果_両足での立位(nullToEmpty(entity.get前回認定remban13()));
            eucEntity.set前回結果_歩行(nullToEmpty(entity.get前回認定remban14()));
            eucEntity.set前回結果_洗身(nullToEmpty(entity.get前回認定remban17()));
            eucEntity.set前回結果_つめ切り(nullToEmpty(entity.get前回認定remban18()));
            eucEntity.set前回結果_視力(nullToEmpty(entity.get前回認定remban19()));
            eucEntity.set前回結果_聴力(nullToEmpty(entity.get前回認定remban20()));
            eucEntity.set前回結果_移乗(nullToEmpty(entity.get前回認定remban21()));
            eucEntity.set前回結果_移動(nullToEmpty(entity.get前回認定remban22()));
            eucEntity.set前回結果_えん下(nullToEmpty(entity.get前回認定remban23()));
            eucEntity.set前回結果_食事摂取(nullToEmpty(entity.get前回認定remban31()));
            eucEntity.set前回結果_排尿(nullToEmpty(entity.get前回認定remban25()));
            eucEntity.set前回結果_排便(nullToEmpty(entity.get前回認定remban26()));
            eucEntity.set前回結果_口腔清潔(nullToEmpty(entity.get前回認定remban27()));
            eucEntity.set前回結果_洗顔(nullToEmpty(entity.get前回認定remban28()));
            eucEntity.set前回結果_整髪(nullToEmpty(entity.get前回認定remban29()));
            eucEntity.set前回結果_上衣の着脱(nullToEmpty(entity.get前回認定remban30()));
            eucEntity.set前回結果_ズボン等の着脱(nullToEmpty(entity.get前回認定remban31()));
            eucEntity.set前回結果_外出頻度(nullToEmpty(entity.get前回認定remban32()));
            eucEntity.set前回結果_意思の伝達(nullToEmpty(entity.get前回認定remban33()));
            eucEntity.set前回結果_毎日の日課を理解(nullToEmpty(entity.get前回認定remban34()));
            eucEntity.set前回結果_生年月日をいう(nullToEmpty(entity.get前回認定remban35()));
            eucEntity.set前回結果_短期記憶(nullToEmpty(entity.get前回認定remban36()));
            eucEntity.set前回結果_自分の名前をいう(nullToEmpty(entity.get前回認定remban37()));
            eucEntity.set前回結果_今の季節を理解(nullToEmpty(entity.get前回認定remban38()));
            eucEntity.set前回結果_場所の理解(nullToEmpty(entity.get前回認定remban39()));
            eucEntity.set前回結果_徘徊(nullToEmpty(entity.get前回認定remban40()));
            eucEntity.set前回結果_外出して戻れない(nullToEmpty(entity.get前回認定remban41()));
            eucEntity.set前回結果_被害的(nullToEmpty(entity.get前回認定remban42()));
            eucEntity.set前回結果_作話(nullToEmpty(entity.get前回認定remban43()));
            eucEntity.set前回結果_感情が不安定(nullToEmpty(entity.get前回認定remban44()));
            eucEntity.set前回結果_昼夜逆転(nullToEmpty(entity.get前回認定remban45()));
            eucEntity.set前回結果_同じ話をする(nullToEmpty(entity.get前回認定remban46()));
            eucEntity.set前回結果_大声を出す(nullToEmpty(entity.get前回認定remban47()));
            eucEntity.set前回結果_介護に抵抗(nullToEmpty(entity.get前回認定remban48()));
            eucEntity.set前回結果_落ち着きなし(nullToEmpty(entity.get前回認定remban49()));
            eucEntity.set前回結果_一人で出たがる(nullToEmpty(entity.get前回認定remban50()));
            eucEntity.set前回結果_収集癖(nullToEmpty(entity.get前回認定remban51()));
            eucEntity.set前回結果_物や衣類を壊す(nullToEmpty(entity.get前回認定remban52()));
            eucEntity.set前回結果_ひどい物忘れ(nullToEmpty(entity.get前回認定remban53()));
            eucEntity.set前回結果_薬の内服(nullToEmpty(entity.get前回認定remban57()));
            eucEntity.set前回結果_金銭の管理(nullToEmpty(entity.get前回認定remban58()));
            eucEntity.set前回結果_日常の意思決定(nullToEmpty(entity.get前回認定remban59()));
            eucEntity.set前回結果_点滴の管理(nullToEmpty(entity.get前回認定remban63()));
            eucEntity.set前回結果_中心静脈栄養(nullToEmpty(entity.get前回認定remban64()));
            eucEntity.set前回結果_透析(nullToEmpty(entity.get前回認定remban65()));
            eucEntity.set前回結果_ストーマの処置(nullToEmpty(entity.get前回認定remban66()));
            eucEntity.set前回結果_酸素療法(nullToEmpty(entity.get前回認定remban67()));
            eucEntity.set前回結果_レスピレーター(nullToEmpty(entity.get前回認定remban68()));
            eucEntity.set前回結果_気管切開の処置(nullToEmpty(entity.get前回認定remban69()));
            eucEntity.set前回結果_疼痛の看護(nullToEmpty(entity.get前回認定remban70()));
            eucEntity.set前回結果_経管栄養(nullToEmpty(entity.get前回認定remban71()));
            eucEntity.set前回結果_モニター測定(nullToEmpty(entity.get前回認定remban72()));
            eucEntity.set前回結果_じょくそうの処置(nullToEmpty(entity.get前回認定remban73()));
            eucEntity.set前回結果_カテーテル(nullToEmpty(entity.get前回認定remban74()));
        }
    }

    private void 予防給付サービス(IchijiHanteizumIfOutputRelateEntity entity, IchijiHanteizumIfOutputEucCsvEntity eucEntity) {
        if (entity.getKoroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_99A.equals(entity.getKoroshoIfShikibetsuCode())
                || (厚労省IF識別コード_02A.equals(entity.getKoroshoIfShikibetsuCode())))) {
            eucEntity.set意見書短期記憶(nullToEmpty(entity.get主治医一時remban16()));
            eucEntity.set意見書認知能力(nullToEmpty(entity.get主治医一時remban17()));
            eucEntity.set意見書伝達能力(nullToEmpty(entity.get主治医一時remban18()));
            eucEntity.set意見書食事行為(nullToEmpty(entity.get主治医一時remban19()));
            eucEntity.set意見書認知症高齢者の日常生活自立度(nullToEmpty(entity.get主治医一時remban15()));
            eucEntity.set短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set短期入所療養介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set特定施設入居者生活介護(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set福祉用具貸与(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set特定福祉用具販売(nullToEmpty(entity.getサービスremban13()));
            eucEntity.set認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban11()));
            eucEntity.set介護予防短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set介護予防短期入所療養介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set介護予防特定施設入居者生活介護(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set介護予防福祉用具貸与(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set特定介護予防福祉用具販売(nullToEmpty(entity.getサービスremban13()));
            eucEntity.set介護予防認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban11()));
        } else {
            eucEntity.set意見書短期記憶(nullToEmpty(entity.get主治医一時remban15()));
            eucEntity.set意見書認知能力(nullToEmpty(entity.get主治医一時remban16()));
            eucEntity.set意見書伝達能力(nullToEmpty(entity.get主治医一時remban17()));
            eucEntity.set意見書食事行為(nullToEmpty(entity.get主治医一時remban69()));
            eucEntity.set意見書認知症高齢者の日常生活自立度(nullToEmpty(entity.get主治医一時remban14()));
            eucEntity.set短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set短期入所療養介護(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set特定施設入居者生活介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set福祉用具貸与(nullToEmpty(entity.getサービスremban11()));
            eucEntity.set特定福祉用具販売(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban16()));
            eucEntity.set介護予防短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set介護予防短期入所療養介護(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set介護予防特定施設入居者生活介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set介護予防福祉用具貸与(nullToEmpty(entity.getサービスremban11()));
            eucEntity.set特定介護予防福祉用具販売(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set介護予防認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban16()));
        }
        if (entity.get前回koroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_99A.equals(entity.get前回koroshoIfShikibetsuCode())
                || (厚労省IF識別コード_02A.equals(entity.get前回koroshoIfShikibetsuCode())))) {
            eucEntity.set夜間対応型訪問介護(RString.EMPTY);
            eucEntity.set認知症対応型通所介護(RString.EMPTY);
            eucEntity.set小規模多機能型居宅介護(RString.EMPTY);
            eucEntity.set地域密着型特定施設入居者生活介護(RString.EMPTY);
            eucEntity.set地域密着型介護老人福祉施設入所者生活介護(RString.EMPTY);
            eucEntity.set介護予防認知症対応型通所介護(RString.EMPTY);
            eucEntity.set介護予防小規模多機能型居宅介護(RString.EMPTY);
        } else {
            eucEntity.set夜間対応型訪問介護(entity.getサービスremban13());
            eucEntity.set認知症対応型通所介護(entity.getサービスremban14());
            eucEntity.set小規模多機能型居宅介護(nullToEmpty(entity.getサービスremban15()));
            eucEntity.set地域密着型特定施設入居者生活介護(nullToEmpty(entity.getサービスremban17()));
            eucEntity.set地域密着型介護老人福祉施設入所者生活介護(nullToEmpty(entity.getサービスremban18()));
            eucEntity.set介護予防認知症対応型通所介護(nullToEmpty(entity.getサービスremban14()));
            eucEntity.set介護予防小規模多機能型居宅介護(nullToEmpty(entity.getサービスremban15()));
        }
        if (entity.getKoroshoIfShikibetsuCode() != null
                && 厚労省IF識別コード_09B.equals(entity.getKoroshoIfShikibetsuCode())) {
            eucEntity.set定期巡回随時対応型訪問介護看護(RString.EMPTY);
            eucEntity.set複合型サービス(RString.EMPTY);
        } else {
            eucEntity.set定期巡回随時対応型訪問介護看護(nullToEmpty(entity.getサービスremban19()));
            eucEntity.set複合型サービス(entity.getサービスremban20());
        }
    }

    private void 前回予防給付サービス(IchijiHanteizumIfOutputRelateEntity entity, IchijiHanteizumIfOutputEucCsvEntity eucEntity) {
        if (entity.getKoroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_99A.equals(entity.getKoroshoIfShikibetsuCode())
                || (厚労省IF識別コード_02A.equals(entity.getKoroshoIfShikibetsuCode())))) {
            eucEntity.set前回結果_短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set前回結果_短期入所療養介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set前回結果_特定施設入居者生活介護(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set前回結果_福祉用具貸与(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set前回結果_特定福祉用具販売(nullToEmpty(entity.getサービスremban13()));
            eucEntity.set前回結果_認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban11()));
            eucEntity.set前回結果_介護予防短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set前回結果_介護予防短期入所療養介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set前回結果_介護予防特定施設入居者生活介護(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set前回結果_介護予防福祉用具貸与(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set前回結果_特定介護予防福祉用具販売(nullToEmpty(entity.getサービスremban13()));
            eucEntity.set前回結果_介護予防認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban11()));
        } else {
            eucEntity.set前回結果_短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set前回結果_短期入所療養介護(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set前回結果_特定施設入居者生活介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set前回結果_福祉用具貸与(nullToEmpty(entity.getサービスremban11()));
            eucEntity.set前回結果_特定福祉用具販売(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set前回結果_認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban16()));
            eucEntity.set前回結果_介護予防短期入所生活介護ショートステイ(nullToEmpty(entity.getサービスremban8()));
            eucEntity.set前回結果_介護予防短期入所療養介護(nullToEmpty(entity.getサービスremban9()));
            eucEntity.set前回結果_介護予防特定施設入居者生活介護(nullToEmpty(entity.getサービスremban10()));
            eucEntity.set前回結果_介護予防福祉用具貸与(nullToEmpty(entity.getサービスremban11()));
            eucEntity.set前回結果_特定介護予防福祉用具販売(nullToEmpty(entity.getサービスremban12()));
            eucEntity.set前回結果_介護予防認知症対応型共同生活介護グループホーム(nullToEmpty(entity.getサービスremban16()));
        }
        if (entity.get前回koroshoIfShikibetsuCode() != null
                && (厚労省IF識別コード_99A.equals(entity.get前回koroshoIfShikibetsuCode())
                || (厚労省IF識別コード_02A.equals(entity.get前回koroshoIfShikibetsuCode())))) {
            eucEntity.set前回結果_夜間対応型訪問介護(RString.EMPTY);
            eucEntity.set前回結果_認知症対応型通所介護(RString.EMPTY);
            eucEntity.set前回結果_小規模多機能型居宅介護(RString.EMPTY);
            eucEntity.set前回結果_地域密着型特定施設入居者生活介護(RString.EMPTY);
            eucEntity.set前回結果_地域密着型介護老人福祉施設入所者生活介護(RString.EMPTY);
            eucEntity.set前回結果_介護予防認知症対応型通所介護(RString.EMPTY);
            eucEntity.set前回結果_介護予防小規模多機能型居宅介護(RString.EMPTY);
        } else {
            eucEntity.set前回結果_夜間対応型訪問介護(entity.getサービスremban13());
            eucEntity.set前回結果_認知症対応型通所介護(entity.getサービスremban14());
            eucEntity.set前回結果_小規模多機能型居宅介護(nullToEmpty(entity.getサービスremban15()));
            eucEntity.set前回結果_地域密着型特定施設入居者生活介護(nullToEmpty(entity.getサービスremban17()));
            eucEntity.set前回結果_地域密着型介護老人福祉施設入所者生活介護(nullToEmpty(entity.getサービスremban18()));
            eucEntity.set前回結果_介護予防認知症対応型通所介護(nullToEmpty(entity.getサービスremban14()));
            eucEntity.set前回結果_介護予防小規模多機能型居宅介護(nullToEmpty(entity.getサービスremban15()));
        }
        if (entity.getKoroshoIfShikibetsuCode() != null
                && 厚労省IF識別コード_09B.equals(entity.getKoroshoIfShikibetsuCode())) {
            eucEntity.set前回結果_定期巡回随時対応型訪問介護看護(RString.EMPTY);
            eucEntity.set前回結果_複合型サービス(RString.EMPTY);
        } else {
            eucEntity.set前回結果_定期巡回随時対応型訪問介護看護(nullToEmpty(entity.getサービスremban19()));
            eucEntity.set前回結果_複合型サービス(entity.getサービスremban20());
        }
    }

    private void 項番編集(NinteichosahyoServiceJokyoRelateEntity entity, NinteichosaJohoTempTableEntity temoTableEntity) {
        switch (nullToEmpty(entity.getRemban()).toString()) {
            case "11":
                temoTableEntity.setRemban11(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "12":
                temoTableEntity.setRemban12(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "13":
                temoTableEntity.setRemban13(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "14":
                temoTableEntity.setRemban14(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "15":
                temoTableEntity.setRemban15(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "16":
                temoTableEntity.setRemban16(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "17":
                temoTableEntity.setRemban17(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "18":
                temoTableEntity.setRemban18(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "19":
                temoTableEntity.setRemban19(nullToEmpty(entity.getServiceJokyo()));
                break;
            case "20":
                temoTableEntity.setRemban20(nullToEmpty(entity.getServiceJokyo()));
                break;
            default:
                break;
        }
    }

    private void 項番編集(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "11":
                temoTableEntity.setRemban11(nullToEmpty(entity.getResearchItem()));
                break;
            case "12":
                temoTableEntity.setRemban12(nullToEmpty(entity.getResearchItem()));
                break;
            case "13":
                temoTableEntity.setRemban13(nullToEmpty(entity.getResearchItem()));
                break;
            case "14":
                temoTableEntity.setRemban14(nullToEmpty(entity.getResearchItem()));
                break;
            case "15":
                temoTableEntity.setRemban15(nullToEmpty(entity.getResearchItem()));
                break;
            case "16":
                temoTableEntity.setRemban16(nullToEmpty(entity.getResearchItem()));
                break;
            case "17":
                temoTableEntity.setRemban17(nullToEmpty(entity.getResearchItem()));
                break;
            case "18":
                temoTableEntity.setRemban18(nullToEmpty(entity.getResearchItem()));
                break;
            case "19":
                temoTableEntity.setRemban19(nullToEmpty(entity.getResearchItem()));
                break;
            case "20":
                temoTableEntity.setRemban20(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private void 項番編集2(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "21":
                temoTableEntity.setRemban21(nullToEmpty(entity.getResearchItem()));
                break;
            case "22":
                temoTableEntity.setRemban22(nullToEmpty(entity.getResearchItem()));
                break;
            case "23":
                temoTableEntity.setRemban23(nullToEmpty(entity.getResearchItem()));
                break;
            case "24":
                temoTableEntity.setRemban24(nullToEmpty(entity.getResearchItem()));
                break;
            case "25":
                temoTableEntity.setRemban25(nullToEmpty(entity.getResearchItem()));
                break;
            case "26":
                temoTableEntity.setRemban26(nullToEmpty(entity.getResearchItem()));
                break;
            case "27":
                temoTableEntity.setRemban27(nullToEmpty(entity.getResearchItem()));
                break;
            case "28":
                temoTableEntity.setRemban28(nullToEmpty(entity.getResearchItem()));
                break;
            case "29":
                temoTableEntity.setRemban29(nullToEmpty(entity.getResearchItem()));
                break;
            case "30":
                temoTableEntity.setRemban30(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private void 項番編集3(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "31":
                temoTableEntity.setRemban31(nullToEmpty(entity.getResearchItem()));
                break;
            case "32":
                temoTableEntity.setRemban32(nullToEmpty(entity.getResearchItem()));
                break;
            case "33":
                temoTableEntity.setRemban33(nullToEmpty(entity.getResearchItem()));
                break;
            case "34":
                temoTableEntity.setRemban34(nullToEmpty(entity.getResearchItem()));
                break;
            case "35":
                temoTableEntity.setRemban35(nullToEmpty(entity.getResearchItem()));
                break;
            case "36":
                temoTableEntity.setRemban36(nullToEmpty(entity.getResearchItem()));
                break;
            case "37":
                temoTableEntity.setRemban37(nullToEmpty(entity.getResearchItem()));
                break;
            case "38":
                temoTableEntity.setRemban38(nullToEmpty(entity.getResearchItem()));
                break;
            case "39":
                temoTableEntity.setRemban39(nullToEmpty(entity.getResearchItem()));
                break;
            case "40":
                temoTableEntity.setRemban40(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private void 項番編集4(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "41":
                temoTableEntity.setRemban41(nullToEmpty(entity.getResearchItem()));
                break;
            case "42":
                temoTableEntity.setRemban42(nullToEmpty(entity.getResearchItem()));
                break;
            case "43":
                temoTableEntity.setRemban43(nullToEmpty(entity.getResearchItem()));
                break;
            case "44":
                temoTableEntity.setRemban44(nullToEmpty(entity.getResearchItem()));
                break;
            case "45":
                temoTableEntity.setRemban45(nullToEmpty(entity.getResearchItem()));
                break;
            case "46":
                temoTableEntity.setRemban46(nullToEmpty(entity.getResearchItem()));
                break;
            case "47":
                temoTableEntity.setRemban47(nullToEmpty(entity.getResearchItem()));
                break;
            case "48":
                temoTableEntity.setRemban48(nullToEmpty(entity.getResearchItem()));
                break;
            case "49":
                temoTableEntity.setRemban49(nullToEmpty(entity.getResearchItem()));
                break;
            case "50":
                temoTableEntity.setRemban50(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private void 項番編集5(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "51":
                temoTableEntity.setRemban51(nullToEmpty(entity.getResearchItem()));
                break;
            case "52":
                temoTableEntity.setRemban52(nullToEmpty(entity.getResearchItem()));
                break;
            case "53":
                temoTableEntity.setRemban53(nullToEmpty(entity.getResearchItem()));
                break;
            case "54":
                temoTableEntity.setRemban54(nullToEmpty(entity.getResearchItem()));
                break;
            case "55":
                temoTableEntity.setRemban55(nullToEmpty(entity.getResearchItem()));
                break;
            case "56":
                temoTableEntity.setRemban56(nullToEmpty(entity.getResearchItem()));
                break;
            case "57":
                temoTableEntity.setRemban57(nullToEmpty(entity.getResearchItem()));
                break;
            case "58":
                temoTableEntity.setRemban58(nullToEmpty(entity.getResearchItem()));
                break;
            case "59":
                temoTableEntity.setRemban59(nullToEmpty(entity.getResearchItem()));
                break;
            case "60":
                temoTableEntity.setRemban60(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private void 項番編集6(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "61":
                temoTableEntity.setRemban61(nullToEmpty(entity.getResearchItem()));
                break;
            case "62":
                temoTableEntity.setRemban62(nullToEmpty(entity.getResearchItem()));
                break;
            case "63":
                temoTableEntity.setRemban63(nullToEmpty(entity.getResearchItem()));
                break;
            case "64":
                temoTableEntity.setRemban64(nullToEmpty(entity.getResearchItem()));
                break;
            case "65":
                temoTableEntity.setRemban65(nullToEmpty(entity.getResearchItem()));
                break;
            case "66":
                temoTableEntity.setRemban66(nullToEmpty(entity.getResearchItem()));
                break;
            case "67":
                temoTableEntity.setRemban67(nullToEmpty(entity.getResearchItem()));
                break;
            case "68":
                temoTableEntity.setRemban68(nullToEmpty(entity.getResearchItem()));
                break;
            case "69":
                temoTableEntity.setRemban69(nullToEmpty(entity.getResearchItem()));
                break;
            case "70":
                temoTableEntity.setRemban70(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private void 項番編集7(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "71":
                temoTableEntity.setRemban71(nullToEmpty(entity.getResearchItem()));
                break;
            case "72":
                temoTableEntity.setRemban72(nullToEmpty(entity.getResearchItem()));
                break;
            case "73":
                temoTableEntity.setRemban73(nullToEmpty(entity.getResearchItem()));
                break;
            case "74":
                temoTableEntity.setRemban74(nullToEmpty(entity.getResearchItem()));
                break;
            case "75":
                temoTableEntity.setRemban75(nullToEmpty(entity.getResearchItem()));
                break;
            case "76":
                temoTableEntity.setRemban76(nullToEmpty(entity.getResearchItem()));
                break;
            case "77":
                temoTableEntity.setRemban77(nullToEmpty(entity.getResearchItem()));
                break;
            case "78":
                temoTableEntity.setRemban78(nullToEmpty(entity.getResearchItem()));
                break;
            case "79":
                temoTableEntity.setRemban79(nullToEmpty(entity.getResearchItem()));
                break;
            case "80":
                temoTableEntity.setRemban80(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private void 項番編集8(NinteichosahyoServiceJokyoRelateEntity entity,
            ChosaItemJohoTempTableEntity temoTableEntity) {
        switch (entity.getRemban().toString()) {
            case "81":
                temoTableEntity.setRemban81(nullToEmpty(entity.getResearchItem()));
                break;
            case "82":
                temoTableEntity.setRemban82(nullToEmpty(entity.getResearchItem()));
                break;
            case "83":
                temoTableEntity.setRemban83(nullToEmpty(entity.getResearchItem()));
                break;
            case "84":
                temoTableEntity.setRemban84(nullToEmpty(entity.getResearchItem()));
                break;
            case "85":
                temoTableEntity.setRemban85(nullToEmpty(entity.getResearchItem()));
                break;
            default:
                break;
        }
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
