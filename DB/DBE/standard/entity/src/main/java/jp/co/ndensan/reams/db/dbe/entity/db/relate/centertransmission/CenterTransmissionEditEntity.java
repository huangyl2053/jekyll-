/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * センター送信データ出力EditEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class CenterTransmissionEditEntity {

    private static final int シーケンシャル番号LENGTH = 6;
    private static final RString EMPTY_VALUE = new RString(0);
    private static final ShinseishoKanriNo EMPTY_申請書管理番号 = new ShinseishoKanriNo("00000000000000000");
    private final CenterTransmissionEntity entity;
    private final int シーケンシャル番号;
    private final RString 連番;

    /**
     * コンストラクタです。
     *
     * @param entity CenterTransmissionEntity
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 連番 連番
     */
    public CenterTransmissionEditEntity(CenterTransmissionEntity entity, int シーケンシャル番号, int 連番) {
        this.entity = entity;
        this.シーケンシャル番号 = シーケンシャル番号;
        this.連番 = new RString(連番);
    }

    /**
     * ファイル出力項目を取得します。
     *
     * @return センター送信データ出力CSV内容
     */
    public CenterTransmissionCsvEntity getファイル出力項目() {
        CenterTransmissionCsvEntity csvEntity = new CenterTransmissionCsvEntity();
        ShinseishoKanriNo 前回申請書管理番号 = entity.getZenkaiShinseishoKanriNo();
        set共通項目(csvEntity);
        set今回項目(csvEntity);
        if (前回申請書管理番号 != null && !前回申請書管理番号.isEmpty() && !EMPTY_申請書管理番号.equals(前回申請書管理番号)) {
            set前回項目(csvEntity);
        }
        return csvEntity;
    }

    private void set共通項目(CenterTransmissionCsvEntity csvEntity) {
        csvEntity.setシーケンシャル番号(new RString(シーケンシャル番号).padZeroToLeft(シーケンシャル番号LENGTH));
        csvEntity.set機能コード(RString.HALF_SPACE);
        csvEntity.set識別コード(entity.getKoroshoIfShikibetsuCode().value());
        csvEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        csvEntity.set被保険者番号(entity.getHihokenshaNo());
        csvEntity.set認定申請日(getValue(entity.getNinteiShinseiYMD()));
        csvEntity.set枝番(this.連番);
        csvEntity.set申請区分申請時コード(entity.getNinteiShinseiShinseijiKubunCode().value());
        csvEntity.set申請区分法令コード(getValue(entity.getNinteiShinseiHoreiKubunCode()));
        csvEntity.set取下区分コード(getValue(entity.getTorisageKubunCode()));
        csvEntity.set被保険者区分コード(entity.getHihokenshaKubunCode());
        csvEntity.set申請代行区分コード(getValue(entity.getShinseiTodokedeDaikoKubunCode()));
        csvEntity.set生年月日(getValue(entity.getSeinengappiYMD()));
        csvEntity.set年齢(new RString(entity.getAge()));
        csvEntity.set性別コード(entity.getSeibetsu().value());
        csvEntity.set被保険者ｶﾅ氏名(entity.getHihokenshaKana().value());
        csvEntity.set被保険者漢字氏名(entity.getHihokenshaName().value());
        csvEntity.set郵便番号(entity.getYubinNo().getEditedYubinNo());
        csvEntity.set住所(entity.getJusho().value());
        csvEntity.set電話番号(entity.getTelNo().value());
        csvEntity.set病院施設等の名称(get名称(entity.getJigyoshaName()));
        csvEntity.set病院施設等の所在地(get名称(entity.getJigyoshaAddress()));
        csvEntity.set前回の認定審査会結果(getValue(entity.getZenYokaigoKubunCode()));
        csvEntity.set前回の認定有効期間開始(getValue(entity.getZenkaiYukoKikanStart()));
        csvEntity.set前回の認定有効期間終了(getValue(entity.getZenkaiYukoKikanEnd()));
        csvEntity.set主治医医療機関番号(get番号(entity.getShujiiIryokikanCode()));
        csvEntity.set主治医番号(get番号(entity.getShujiiCode()));
        csvEntity.set意見書依頼日(getValue(entity.getIkenshoSakuseiIraiYMD()));
        csvEntity.set意見書入手日(getValue(entity.getIkenshoJuryoYMD()));
        csvEntity.set意見書短期記憶(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                entity.getIkenItemKoban16(), entity.getIkenItemKoban15()));
        csvEntity.set意見書認知能力(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                entity.getIkenItemKoban17(), entity.getIkenItemKoban16()));
        csvEntity.set意見書伝達能力(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                entity.getIkenItemKoban18(), entity.getIkenItemKoban17()));
        csvEntity.set意見書食事行為(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                entity.getIkenItemKoban19(), entity.getIkenItemKoban69()));
        csvEntity.set意見書認知症高齢者の日常生活自立度(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                entity.getIkenItemKoban15(), entity.getIkenItemKoban14()));
        csvEntity.set調査依頼日(getValue(entity.getNinteichosaIraiYMD()));
        csvEntity.set調査実施日(getValue(entity.getNinteichosaJisshiYMD()));
        csvEntity.set指定居宅介護支援事業者等番号(get番号(entity.getJigyoshaNo()));
        csvEntity.set委託区分(get調査委託区分(entity.getChosaItakuKubun()));
        csvEntity.set認定調査員番号(entity.getNinteiChosainCode());
        csvEntity.set認定調査員資格コード(entity.getChosainShikaku());
        csvEntity.set認定審査会意見等(entity.getShinsakaiIken());
        csvEntity.setコメント等(entity.getShinsakaiMemo());
    }

    private void set今回項目(CenterTransmissionCsvEntity csvEntity) {
        csvEntity.set一次判定日(getValue(entity.getIchijiHanteiYMD()));
        csvEntity.set一次判定結果(getValue(entity.getIchijiHanteiKekkaCode()));
        csvEntity.set一次判定結果認知症加算(getValue(entity.getIchijiHanteiKekkaNinchishoKasanCode()));
        csvEntity.set要介護認定等基準時間(new RString(entity.getKijunJikan()));
        csvEntity.set要介護認定等基準時間食事(new RString(entity.getKijunJikanShokuji()));
        csvEntity.set要介護認定等基準時間排泄(new RString(entity.getKijunJikanHaisetsu()));
        csvEntity.set要介護認定等基準時間移動(new RString(entity.getKijunJikanIdo()));
        csvEntity.set要介護認定等基準時間清潔保持(new RString(entity.getKijunJikanSeiketsuHoji()));
        csvEntity.set要介護認定等基準時間間接ケア(new RString(entity.getKijunJikanKansetsuCare()));
        csvEntity.set要介護認定等基準時間BPSD関連(new RString(entity.getKijunJikanBPSDKanren()));
        csvEntity.set要介護認定等基準時間機能訓練(new RString(entity.getKijunJikanKinoKunren()));
        csvEntity.set要介護認定等基準時間医療関連(new RString(entity.getKijunJikanIryoKanren()));
        csvEntity.set要介護認定等基準時間認知症加算(new RString(entity.getKijunJikanNinchishoKasan()));
        csvEntity.set中間評価項目得点第１群(new RString(entity.getChukanHyokaKomoku1gun()));
        csvEntity.set中間評価項目得点第２群(new RString(entity.getChukanHyokaKomoku2gun()));
        csvEntity.set中間評価項目得点第３群(new RString(entity.getChukanHyokaKomoku3gun()));
        csvEntity.set中間評価項目得点第４群(new RString(entity.getChukanHyokaKomoku4gun()));
        csvEntity.set中間評価項目得点第５群(new RString(entity.getChukanHyokaKomoku5gun()));
        csvEntity.set一次判定警告配列コード(entity.getIchijiHnateiKeikokuCode());
        csvEntity.set状態の安定性(getValue(entity.getJotaiAnteiseiCode()));
        csvEntity.set認知症自立度Ⅱ以上の蓋然性(getValue(entity.getNinchishoJiritsudoIIijoNoGaizensei()));
        csvEntity.set認知機能及び状態安定性から推定される給付区分(getValue(entity.getSuiteiKyufuKubunCode()));
        csvEntity.set認定審査会資料作成日(getValue(entity.getShinsakaiShiryoSakuseiYMD()));
        csvEntity.set認定審査会予定日(getValue(entity.getShinsakaiKaisaiYoteiYMD()));
        csvEntity.set合議体番号(new RString(entity.getGogitaiNo()));
        csvEntity.set審査会資料番号(RString.EMPTY);
        csvEntity.set二次判定日(getValue(entity.getNijiHanteiYMD()));
        csvEntity.set二次判定結果(getValue(entity.getNijiHanteiYokaigoJotaiKubunCode()));
        csvEntity.set認定有効期間開始(getValue(entity.getNijiHanteiNinteiYukoKaishiYMD()));
        csvEntity.set認定有効期間終了(getValue(entity.getNijiHanteiNinteiYukoShuryoYMD()));
        csvEntity.set特定疾病コード(getValue(entity.getNigoTokuteiShippeiCode()));
        csvEntity.set要介護１の場合の状態像(getValue(entity.getYokaigoJotaizoReiCode()));
        csvEntity.set現在のサービス区分コード(getValue(entity.getServiceKubunCode()));
        csvEntity.set現在の状況(entity.getRemban() == 0 ? new RString(1) : new RString(entity.getRemban()));

        Code サービス区分コード = entity.getServiceKubunCode();
        if (サービス区分コード == null || RString.isNullOrEmpty(サービス区分コード.value())) {
            サービス区分コード = new Code(ServiceKubunCode.なし.getコード());
        }
        initializeサービスの状況(csvEntity);
        if (ServiceKubunCode.介護給付サービス == ServiceKubunCode.toValue(サービス区分コード.value())) {
            csvEntity.set訪問介護ホームヘルプサービス(new RString(entity.getServiceJokyoKoban1()));
            csvEntity.set訪問入浴介護(new RString(entity.getServiceJokyoKoban2()));
            csvEntity.set訪問看護(new RString(entity.getServiceJokyoKoban3()));
            csvEntity.set訪問リハビリテーション(new RString(entity.getServiceJokyoKoban4()));
            csvEntity.set居宅療養管理指導(new RString(entity.getServiceJokyoKoban5()));
            csvEntity.set通所介護デイサービス(new RString(entity.getServiceJokyoKoban6()));
            csvEntity.set通所リハビリテーション(new RString(entity.getServiceJokyoKoban7()));
            csvEntity.set短期入所生活介護ショートステイ(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban9()), new RString(entity.getServiceJokyoKoban8())));
            csvEntity.set短期入所療養介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban10()), new RString(entity.getServiceJokyoKoban9())));
            csvEntity.set特定施設入居者生活介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban12()), new RString(entity.getServiceJokyoKoban10())));
            csvEntity.set福祉用具貸与(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban8()), new RString(entity.getServiceJokyoKoban11())));
            csvEntity.set特定福祉用具販売(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban13()), new RString(entity.getServiceJokyoKoban12())));
            csvEntity.set住宅改修介護給付(getValue(entity.isServiceJokyoFlag()));
            csvEntity.set夜間対応型訪問介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getServiceJokyoKoban13())));
            csvEntity.set認知症対応型通所介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getServiceJokyoKoban14())));
            csvEntity.set小規模多機能型居宅介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getServiceJokyoKoban15())));
            csvEntity.set認知症対応型共同生活介護グループホーム(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban11()), new RString(entity.getServiceJokyoKoban16())));
            csvEntity.set地域密着型特定施設入居者生活介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getServiceJokyoKoban17())));
            csvEntity.set地域密着型介護老人福祉施設入所者生活介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getServiceJokyoKoban18())));
            csvEntity.set定期巡回随時対応型訪問介護看護(get項目By厚労省99B以外(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban19())));
            csvEntity.set複合型サービス(get項目By厚労省99B以外(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban20())));
        } else if (ServiceKubunCode.予防給付サービス == ServiceKubunCode.toValue(サービス区分コード.value())) {
            csvEntity.set介護予防訪問介護ホームヘルプサービス(new RString(entity.getServiceJokyoKoban1()));
            csvEntity.set介護予防訪問入浴介護(new RString(entity.getServiceJokyoKoban2()));
            csvEntity.set介護予防訪問看護(new RString(entity.getServiceJokyoKoban3()));
            csvEntity.set介護予防訪問リハビリテーション(new RString(entity.getServiceJokyoKoban4()));
            csvEntity.set介護予防居宅療養管理指導(new RString(entity.getServiceJokyoKoban5()));
            csvEntity.set介護予防通所介護デイサービス(new RString(entity.getServiceJokyoKoban6()));
            csvEntity.set介護予防通所リハビリテーション(new RString(entity.getServiceJokyoKoban7()));
            csvEntity.set介護予防短期入所生活介護ショートステイ(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban9()), new RString(entity.getServiceJokyoKoban8())));
            csvEntity.set介護予防短期入所療養介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban10()), new RString(entity.getServiceJokyoKoban9())));
            csvEntity.set介護予防特定施設入居者生活介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban12()), new RString(entity.getServiceJokyoKoban10())));
            csvEntity.set介護予防福祉用具貸与(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban8()), new RString(entity.getServiceJokyoKoban11())));
            csvEntity.set特定介護予防福祉用具販売(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban13()), new RString(entity.getServiceJokyoKoban12())));
            csvEntity.set住宅改修予防給付(getValue(entity.isServiceJokyoFlag()));
            csvEntity.set介護予防認知症対応型通所介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getServiceJokyoKoban14())));
            csvEntity.set介護予防小規模多機能型居宅介護(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getServiceJokyoKoban15())));
            csvEntity.set介護予防認知症対応型共同生活介護グループホーム(get項目By厚労省99Aと02A(entity.getKoroshoIfShikibetsuCode(),
                    new RString(entity.getServiceJokyoKoban11()), new RString(entity.getServiceJokyoKoban16())));
        }
        csvEntity.set障害高齢者自立度(getValue(entity.getShogaiNichijoSeikatsuJiritsudoCode()));
        csvEntity.set認知症高齢者自立度(getValue(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        set今回調査項目(csvEntity);
    }

    private void set今回調査項目(CenterTransmissionCsvEntity csvEntity) {
        csvEntity.set麻痺左上肢(entity.getChosaItemKoban1());
        csvEntity.set麻痺右上肢(entity.getChosaItemKoban2());
        csvEntity.set麻痺左下肢(entity.getChosaItemKoban3());
        csvEntity.set麻痺右下肢(entity.getChosaItemKoban4());
        csvEntity.set麻痺その他(entity.getChosaItemKoban5());
        csvEntity.set拘縮肩関節(entity.getChosaItemKoban6());
        csvEntity.set拘縮股関節(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban8(), entity.getChosaItemKoban7()));
        csvEntity.set拘縮膝関節(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban9(), entity.getChosaItemKoban8()));
        csvEntity.set拘縮その他(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban11(), entity.getChosaItemKoban9()));
        csvEntity.set寝返り(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban12(), entity.getChosaItemKoban10()));
        csvEntity.set起き上がり(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban13(), entity.getChosaItemKoban11()));
        csvEntity.set座位保持(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban14(), entity.getChosaItemKoban12()));
        csvEntity.set両足での立位(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban16(), entity.getChosaItemKoban15(), entity.getChosaItemKoban13()));
        csvEntity.set歩行(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban17(), entity.getChosaItemKoban16(), entity.getChosaItemKoban14()));
        csvEntity.set立ち上がり(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban19(), entity.getChosaItemKoban15()));
        csvEntity.set片足での立位(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban20(), entity.getChosaItemKoban16()));
        csvEntity.set洗身(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban22(), entity.getChosaItemKoban21(), entity.getChosaItemKoban17()));
        csvEntity.setつめ切り(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban35(), entity.getChosaItemKoban32(), entity.getChosaItemKoban18()));
        csvEntity.set視力(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban45(), entity.getChosaItemKoban39(), entity.getChosaItemKoban19()));
        csvEntity.set聴力(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban46(), entity.getChosaItemKoban40(), entity.getChosaItemKoban20()));
        csvEntity.set移乗(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban18(), entity.getChosaItemKoban17(), entity.getChosaItemKoban21()));
        csvEntity.set移動(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban18(), entity.getChosaItemKoban22()));
        csvEntity.setえん下(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban26(), entity.getChosaItemKoban24(), entity.getChosaItemKoban23()));
        csvEntity.set食事摂取(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban31(), entity.getChosaItemKoban25(), entity.getChosaItemKoban24()));
        csvEntity.set排尿(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban27(), entity.getChosaItemKoban25()));
        csvEntity.set排便(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban28(), entity.getChosaItemKoban26()));
        csvEntity.set口腔清潔(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban32(), entity.getChosaItemKoban29(), entity.getChosaItemKoban27()));
        csvEntity.set洗顔(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban33(), entity.getChosaItemKoban30(), entity.getChosaItemKoban28()));
        csvEntity.set整髪(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban34(), entity.getChosaItemKoban31(), entity.getChosaItemKoban29()));
        csvEntity.set上衣の着脱(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban37(), entity.getChosaItemKoban33(), entity.getChosaItemKoban30()));
        csvEntity.setズボン等の着脱(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban38(), entity.getChosaItemKoban34(), entity.getChosaItemKoban31()));
        csvEntity.set外出頻度(get項目By厚労省99Aと02ABy06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban81(), entity.getChosaItemKoban32()));
        csvEntity.set意思の伝達(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban47(), entity.getChosaItemKoban41(), entity.getChosaItemKoban33()));
        csvEntity.set毎日の日課を理解(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban49(), entity.getChosaItemKoban43(), entity.getChosaItemKoban34()));
        csvEntity.set生年月日をいう(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban50(), entity.getChosaItemKoban44(), entity.getChosaItemKoban35()));
        csvEntity.set短期記憶(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban51(), entity.getChosaItemKoban45(), entity.getChosaItemKoban36()));
        csvEntity.set自分の名前をいう(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban52(), entity.getChosaItemKoban46(), entity.getChosaItemKoban37()));
        csvEntity.set今の季節を理解(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban53(), entity.getChosaItemKoban47(), entity.getChosaItemKoban38()));
        csvEntity.set場所の理解(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban54(), entity.getChosaItemKoban48(), entity.getChosaItemKoban39()));
        csvEntity.set徘徊(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban64(), entity.getChosaItemKoban58(), entity.getChosaItemKoban40()));
        csvEntity.set外出して戻れない(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban66(), entity.getChosaItemKoban60(), entity.getChosaItemKoban41()));
        csvEntity.set被害的(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban55(), entity.getChosaItemKoban49(), entity.getChosaItemKoban42()));
        csvEntity.set作話(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban56(), entity.getChosaItemKoban50(), entity.getChosaItemKoban43()));
        csvEntity.set感情が不安定(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban58(), entity.getChosaItemKoban52(), entity.getChosaItemKoban44()));
        csvEntity.set昼夜逆転(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban59(), entity.getChosaItemKoban53(), entity.getChosaItemKoban45()));
        csvEntity.set同じ話をする(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban61(), entity.getChosaItemKoban55(), entity.getChosaItemKoban46()));
        csvEntity.set大声を出す(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban62(), entity.getChosaItemKoban56(), entity.getChosaItemKoban47()));
        csvEntity.set介護に抵抗(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban63(), entity.getChosaItemKoban57(), entity.getChosaItemKoban48()));
        csvEntity.set落ち着きなし(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban65(), entity.getChosaItemKoban59(), entity.getChosaItemKoban49()));
        csvEntity.set一人で出たがる(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban67(), entity.getChosaItemKoban61(), entity.getChosaItemKoban50()));
        csvEntity.set収集癖(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban68(), entity.getChosaItemKoban62(), entity.getChosaItemKoban51()));
        csvEntity.set物や衣類を壊す(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban70(), entity.getChosaItemKoban64(), entity.getChosaItemKoban52()));
        csvEntity.setひどい物忘れ(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban43(), entity.getChosaItemKoban67(), entity.getChosaItemKoban53()));
        csvEntity.set独り言独り笑い(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban54()));
        csvEntity.set自分勝手に行動する(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban55()));
        csvEntity.set話がまとまらない(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban56()));
        csvEntity.set薬の内服(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban41(), entity.getChosaItemKoban35(), entity.getChosaItemKoban57()));
        csvEntity.set金銭の管理(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban42(), entity.getChosaItemKoban36(), entity.getChosaItemKoban58()));
        csvEntity.set日常の意思決定(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban38(), entity.getChosaItemKoban59()));
        csvEntity.set集団への不適応(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban60()));
        csvEntity.set買い物(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban61()));
        csvEntity.set簡単な調理(get項目By厚労省99Aと02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getChosaItemKoban62()));
        csvEntity.set点滴の管理(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban74(), entity.getChosaItemKoban68(), entity.getChosaItemKoban63()));
        csvEntity.set中心静脈栄養(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban75(), entity.getChosaItemKoban69(), entity.getChosaItemKoban64()));
        csvEntity.set透析(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban76(), entity.getChosaItemKoban70(), entity.getChosaItemKoban65()));
        csvEntity.setストーマの処置(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban77(), entity.getChosaItemKoban71(), entity.getChosaItemKoban66()));
        csvEntity.set酸素療法(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban78(), entity.getChosaItemKoban72(), entity.getChosaItemKoban67()));
        csvEntity.setレスピレーター(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban79(), entity.getChosaItemKoban73(), entity.getChosaItemKoban68()));
        csvEntity.set気管切開の処置(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban80(), entity.getChosaItemKoban74(), entity.getChosaItemKoban69()));
        csvEntity.set疼痛の看護(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban81(), entity.getChosaItemKoban75(), entity.getChosaItemKoban70()));
        csvEntity.set経管栄養(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban82(), entity.getChosaItemKoban76(), entity.getChosaItemKoban71()));
        csvEntity.setモニター測定(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban83(), entity.getChosaItemKoban77(), entity.getChosaItemKoban72()));
        csvEntity.setじょくそうの処置(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban84(), entity.getChosaItemKoban78(), entity.getChosaItemKoban73()));
        csvEntity.setカテーテル(get項目By厚労省99ABy02Aと06A(entity.getKoroshoIfShikibetsuCode(),
                entity.getChosaItemKoban85(), entity.getChosaItemKoban79(), entity.getChosaItemKoban74()));
    }

    private void set前回項目(CenterTransmissionCsvEntity csvEntity) {
        set前回調査項目(csvEntity);
        csvEntity.set前回結果_障害高齢者自立度(getValue(entity.getZenkaiShogaiNichijoSeikatsuJiritsudoCode()));
        csvEntity.set前回結果_認知症高齢者自立度(getValue(entity.getZenkaiNinchishoNichijoSeikatsuJiritsudoCode()));
        csvEntity.set前回結果_一次判定結果(getValue(entity.getZenkaiIchijiHanteiKekkaCode()));
        csvEntity.set前回結果_一次判定結果認知症加算(getValue(entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode()));
        csvEntity.set前回結果_要介護認定等基準時間(new RString(entity.getZenkaiKijunJikan()));
        csvEntity.set前回結果_要介護認定等基準時間食事(new RString(entity.getZenkaiKijunJikanShokuji()));
        csvEntity.set前回結果_要介護認定等基準時間排泄(new RString(entity.getZenkaiKijunJikanHaisetsu()));
        csvEntity.set前回結果_要介護認定等基準時間移動(new RString(entity.getZenkaiKijunJikanIdo()));
        csvEntity.set前回結果_要介護認定等基準時間清潔保持(new RString(entity.getZenkaiKijunJikanSeiketsuHoji()));
        csvEntity.set前回結果_要介護認定等基準時間間接ケア(new RString(entity.getZenkaiKijunJikanKansetsuCare()));
        csvEntity.set前回結果_要介護認定等基準時間BPSD関連(new RString(entity.getZenkaiKijunJikanBPSDKanren()));
        csvEntity.set前回結果_要介護認定等基準時間機能訓練(new RString(entity.getZenkaiKijunJikanKinoKunren()));
        csvEntity.set前回結果_要介護認定等基準時間医療関連(new RString(entity.getZenkaiKijunJikanIryoKanren()));
        csvEntity.set前回結果_要介護認定等基準時間認知症加算(new RString(entity.getZenkaiKijunJikanNinchishoKasan()));
        csvEntity.set前回結果_中間評価項目得点第１群(new RString(entity.getZenkaiChukanHyokaKomoku1gun()));
        csvEntity.set前回結果_中間評価項目得点第２群(new RString(entity.getZenkaiChukanHyokaKomoku2gun()));
        csvEntity.set前回結果_中間評価項目得点第３群(new RString(entity.getZenkaiChukanHyokaKomoku3gun()));
        csvEntity.set前回結果_中間評価項目得点第４群(new RString(entity.getZenkaiChukanHyokaKomoku4gun()));
        csvEntity.set前回結果_中間評価項目得点第５群(new RString(entity.getZenkaiChukanHyokaKomoku5gun()));
        csvEntity.set前回結果_一次判定警告コード(entity.getZenkaiChijiHnateiKeikokuCode());
        csvEntity.set前回結果_状態の安定性(getValue(entity.getZenkaiJotaiAnteiseiCode()));
        csvEntity.set前回結果_認知症自立度Ⅱ以上の蓋然性(getValue(entity.getZenkaiNinchishoJiritsudoIIijoNoGaizensei()));
        csvEntity.set前回結果_認知機能及び状態安定性から推定される給付区分(getValue(entity.getZenkaiSuiteiKyufuKubunCode()));
        csvEntity.set前回結果_申請日(getValue(entity.getZenkaiNinteiShinseiYMD()));
        csvEntity.set前回結果_二次判定日(getValue(entity.getZenkaiNijiHanteiYMD()));
        csvEntity.set前回結果_現在のサービス区分コード(getValue(entity.getZenkaiServiceKubunCode()));
        csvEntity.set前回結果_現在の状況(entity.getZenkaiRemban() == 0 ? new RString(1) : new RString(entity.getZenkaiRemban()));

        Code サービス区分コード = entity.getZenkaiServiceKubunCode();
        if (サービス区分コード == null || RString.isNullOrEmpty(サービス区分コード.value())) {
            サービス区分コード = new Code(ServiceKubunCode.なし.getコード());
        }
        initialize前回サービスの状況(csvEntity);
        if (ServiceKubunCode.介護給付サービス == ServiceKubunCode.toValue(サービス区分コード.value())) {
            csvEntity.set前回結果_訪問介護ホームヘルプサービス(new RString(entity.getZenkaiServiceJokyoKoban1()));
            csvEntity.set前回結果_訪問入浴介護(new RString(entity.getZenkaiServiceJokyoKoban2()));
            csvEntity.set前回結果_訪問看護(new RString(entity.getZenkaiServiceJokyoKoban3()));
            csvEntity.set前回結果_訪問リハビリテーション(new RString(entity.getZenkaiServiceJokyoKoban4()));
            csvEntity.set前回結果_居宅療養管理指導(new RString(entity.getZenkaiServiceJokyoKoban5()));
            csvEntity.set前回結果_通所介護デイサービス(new RString(entity.getZenkaiServiceJokyoKoban6()));
            csvEntity.set前回結果_通所リハビリテーション(new RString(entity.getZenkaiServiceJokyoKoban7()));
            csvEntity.set前回結果_短期入所生活介護ショートステイ(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban9()), new RString(entity.getZenkaiServiceJokyoKoban8())));
            csvEntity.set前回結果_短期入所療養介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban10()), new RString(entity.getZenkaiServiceJokyoKoban9())));
            csvEntity.set前回結果_特定施設入居者生活介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban12()), new RString(entity.getZenkaiServiceJokyoKoban10())));
            csvEntity.set前回結果_福祉用具貸与(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban8()), new RString(entity.getZenkaiServiceJokyoKoban11())));
            csvEntity.set前回結果_特定福祉用具販売(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban13()), new RString(entity.getZenkaiServiceJokyoKoban12())));
            csvEntity.set前回結果_住宅改修介護給付(getValue(entity.isZenkaiServiceJokyoFlag()));
            csvEntity.set前回結果_夜間対応型訪問介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getZenkaiServiceJokyoKoban13())));
            csvEntity.set前回結果_認知症対応型通所介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getZenkaiServiceJokyoKoban14())));
            csvEntity.set前回結果_小規模多機能型居宅介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getZenkaiServiceJokyoKoban15())));
            csvEntity.set前回結果_認知症対応型共同生活介護グループホーム(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban11()), new RString(entity.getZenkaiServiceJokyoKoban16())));
            csvEntity.set前回結果_地域密着型特定施設入居者生活介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getZenkaiServiceJokyoKoban17())));
            csvEntity.set前回結果_地域密着型介護老人福祉施設入所者生活介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getZenkaiServiceJokyoKoban18())));
            csvEntity.set前回結果_定期巡回随時対応型訪問介護看護(get項目By厚労省99B以外(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban19())));
            csvEntity.set前回結果_複合型サービス(get項目By厚労省99B以外(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban20())));

        } else if (ServiceKubunCode.予防給付サービス == ServiceKubunCode.toValue(サービス区分コード.value())) {
            csvEntity.set前回結果_介護予防訪問介護ホームヘルプサービス(new RString(entity.getZenkaiServiceJokyoKoban1()));
            csvEntity.set前回結果_介護予防訪問入浴介護(new RString(entity.getZenkaiServiceJokyoKoban2()));
            csvEntity.set前回結果_介護予防訪問看護(new RString(entity.getZenkaiServiceJokyoKoban3()));
            csvEntity.set前回結果_介護予防訪問リハビリテーション(new RString(entity.getZenkaiServiceJokyoKoban4()));
            csvEntity.set前回結果_介護予防居宅療養管理指導(new RString(entity.getZenkaiServiceJokyoKoban5()));
            csvEntity.set前回結果_介護予防通所介護デイサービス(new RString(entity.getZenkaiServiceJokyoKoban6()));
            csvEntity.set前回結果_介護予防通所リハビリテーション(new RString(entity.getZenkaiServiceJokyoKoban7()));
            csvEntity.set前回結果_介護予防短期入所生活介護ショートステイ(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban9()), new RString(entity.getZenkaiServiceJokyoKoban8())));
            csvEntity.set前回結果_介護予防短期入所療養介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban10()), new RString(entity.getZenkaiServiceJokyoKoban9())));
            csvEntity.set前回結果_介護予防特定施設入居者生活介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban12()), new RString(entity.getZenkaiServiceJokyoKoban10())));
            csvEntity.set前回結果_介護予防福祉用具貸与(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban8()), new RString(entity.getZenkaiServiceJokyoKoban11())));
            csvEntity.set前回結果_特定介護予防福祉用具販売(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban13()), new RString(entity.getZenkaiServiceJokyoKoban12())));
            csvEntity.set前回結果_住宅改修予防給付(getValue(entity.isZenkaiServiceJokyoFlag()));
            csvEntity.set前回結果_介護予防認知症対応型通所介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getZenkaiServiceJokyoKoban14())));
            csvEntity.set前回結果_介護予防小規模多機能型居宅介護(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    RString.EMPTY, new RString(entity.getZenkaiServiceJokyoKoban15())));
            csvEntity.set前回結果_介護予防認知症対応型共同生活介護グループホーム(get項目By厚労省99Aと02A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                    new RString(entity.getZenkaiServiceJokyoKoban11()), new RString(entity.getZenkaiServiceJokyoKoban16())));

        }
        csvEntity.set前回識別コード(getValue(entity.getZenkaiKoroshoIfShikibetsuCode()));
    }

    private void set前回調査項目(CenterTransmissionCsvEntity csvEntity) {
        csvEntity.set前回結果_麻痺左上肢(entity.getZenkaiChosaItemKoban1());
        csvEntity.set前回結果_麻痺右上肢(entity.getZenkaiChosaItemKoban2());
        csvEntity.set前回結果_麻痺左下肢(entity.getZenkaiChosaItemKoban3());
        csvEntity.set前回結果_麻痺右下肢(entity.getZenkaiChosaItemKoban4());
        csvEntity.set前回結果_麻痺その他(entity.getZenkaiChosaItemKoban5());
        csvEntity.set前回結果_拘縮肩関節(entity.getZenkaiChosaItemKoban6());
        csvEntity.set前回結果_拘縮股関節(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban8(), entity.getZenkaiChosaItemKoban7()));
        csvEntity.set前回結果_拘縮膝関節(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban9(), entity.getZenkaiChosaItemKoban8()));
        csvEntity.set前回結果_拘縮その他(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban11(), entity.getZenkaiChosaItemKoban9()));
        csvEntity.set前回結果_寝返り(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban12(), entity.getZenkaiChosaItemKoban10()));
        csvEntity.set前回結果_起き上がり(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban13(), entity.getZenkaiChosaItemKoban11()));
        csvEntity.set前回結果_座位保持(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban14(), entity.getZenkaiChosaItemKoban12()));
        csvEntity.set前回結果_両足での立位(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban16(), entity.getZenkaiChosaItemKoban15(), entity.getZenkaiChosaItemKoban13()));
        csvEntity.set前回結果_歩行(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban17(), entity.getZenkaiChosaItemKoban16(), entity.getZenkaiChosaItemKoban14()));
        csvEntity.set前回結果_立ち上がり(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban19(), entity.getZenkaiChosaItemKoban15()));
        csvEntity.set前回結果_片足での立位(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban20(), entity.getZenkaiChosaItemKoban16()));
        csvEntity.set前回結果_洗身(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban22(), entity.getZenkaiChosaItemKoban21(), entity.getZenkaiChosaItemKoban17()));
        csvEntity.set前回結果_つめ切り(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban35(), entity.getZenkaiChosaItemKoban32(), entity.getZenkaiChosaItemKoban18()));
        csvEntity.set前回結果_視力(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban45(), entity.getZenkaiChosaItemKoban39(), entity.getZenkaiChosaItemKoban19()));
        csvEntity.set前回結果_聴力(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban46(), entity.getZenkaiChosaItemKoban40(), entity.getZenkaiChosaItemKoban20()));
        csvEntity.set前回結果_移乗(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban18(), entity.getZenkaiChosaItemKoban17(), entity.getZenkaiChosaItemKoban21()));
        csvEntity.set前回結果_移動(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban18(), entity.getZenkaiChosaItemKoban22()));
        csvEntity.set前回結果_えん下(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban26(), entity.getZenkaiChosaItemKoban24(), entity.getZenkaiChosaItemKoban23()));
        csvEntity.set前回結果_食事摂取(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban31(), entity.getZenkaiChosaItemKoban25(), entity.getZenkaiChosaItemKoban24()));
        csvEntity.set前回結果_排尿(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban27(), entity.getZenkaiChosaItemKoban25()));
        csvEntity.set前回結果_排便(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban28(), entity.getZenkaiChosaItemKoban26()));
        csvEntity.set前回結果_口腔清潔(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban32(), entity.getZenkaiChosaItemKoban29(), entity.getZenkaiChosaItemKoban27()));
        csvEntity.set前回結果_洗顔(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban33(), entity.getZenkaiChosaItemKoban30(), entity.getZenkaiChosaItemKoban28()));
        csvEntity.set前回結果_整髪(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban34(), entity.getZenkaiChosaItemKoban31(), entity.getZenkaiChosaItemKoban29()));
        csvEntity.set前回結果_上衣の着脱(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban37(), entity.getZenkaiChosaItemKoban33(), entity.getZenkaiChosaItemKoban30()));
        csvEntity.set前回結果_ズボン等の着脱(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban38(), entity.getZenkaiChosaItemKoban34(), entity.getZenkaiChosaItemKoban31()));
        csvEntity.set前回結果_外出頻度(get項目By厚労省99Aと02ABy06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban81(), entity.getZenkaiChosaItemKoban32()));
        csvEntity.set前回結果_意思の伝達(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban47(), entity.getZenkaiChosaItemKoban41(), entity.getZenkaiChosaItemKoban33()));
        csvEntity.set前回結果_毎日の日課を理解(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban49(), entity.getZenkaiChosaItemKoban43(), entity.getZenkaiChosaItemKoban34()));
        csvEntity.set前回結果_生年月日をいう(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban50(), entity.getZenkaiChosaItemKoban44(), entity.getZenkaiChosaItemKoban35()));
        csvEntity.set前回結果_短期記憶(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban51(), entity.getZenkaiChosaItemKoban45(), entity.getZenkaiChosaItemKoban36()));
        csvEntity.set前回結果_自分の名前をいう(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban52(), entity.getZenkaiChosaItemKoban46(), entity.getZenkaiChosaItemKoban37()));
        csvEntity.set前回結果_今の季節を理解(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban53(), entity.getZenkaiChosaItemKoban47(), entity.getZenkaiChosaItemKoban38()));
        csvEntity.set前回結果_場所の理解(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban54(), entity.getZenkaiChosaItemKoban48(), entity.getZenkaiChosaItemKoban39()));
        csvEntity.set前回結果_徘徊(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban64(), entity.getZenkaiChosaItemKoban58(), entity.getZenkaiChosaItemKoban40()));
        csvEntity.set前回結果_外出して戻れない(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban66(), entity.getZenkaiChosaItemKoban60(), entity.getZenkaiChosaItemKoban41()));
        csvEntity.set前回結果_被害的(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban55(), entity.getZenkaiChosaItemKoban49(), entity.getZenkaiChosaItemKoban42()));
        csvEntity.set前回結果_作話(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban56(), entity.getZenkaiChosaItemKoban50(), entity.getZenkaiChosaItemKoban43()));
        csvEntity.set前回結果_感情が不安定(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban58(), entity.getZenkaiChosaItemKoban52(), entity.getZenkaiChosaItemKoban44()));
        csvEntity.set前回結果_昼夜逆転(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban59(), entity.getZenkaiChosaItemKoban53(), entity.getZenkaiChosaItemKoban45()));
        csvEntity.set前回結果_同じ話をする(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban61(), entity.getZenkaiChosaItemKoban55(), entity.getZenkaiChosaItemKoban46()));
        csvEntity.set前回結果_大声を出す(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban62(), entity.getZenkaiChosaItemKoban56(), entity.getZenkaiChosaItemKoban47()));
        csvEntity.set前回結果_介護に抵抗(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban63(), entity.getZenkaiChosaItemKoban57(), entity.getZenkaiChosaItemKoban48()));
        csvEntity.set前回結果_落ち着きなし(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban65(), entity.getZenkaiChosaItemKoban59(), entity.getZenkaiChosaItemKoban49()));
        csvEntity.set前回結果_一人で出たがる(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban67(), entity.getZenkaiChosaItemKoban61(), entity.getZenkaiChosaItemKoban50()));
        csvEntity.set前回結果_収集癖(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban68(), entity.getZenkaiChosaItemKoban62(), entity.getZenkaiChosaItemKoban51()));
        csvEntity.set前回結果_物や衣類を壊す(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban70(), entity.getZenkaiChosaItemKoban64(), entity.getZenkaiChosaItemKoban52()));
        csvEntity.set前回結果_ひどい物忘れ(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban43(), entity.getZenkaiChosaItemKoban67(), entity.getZenkaiChosaItemKoban53()));
        csvEntity.set前回結果_独り言独り笑い(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban54()));
        csvEntity.set前回結果_自分勝手に行動する(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban55()));
        csvEntity.set前回結果_話がまとまらない(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban56()));
        csvEntity.set前回結果_薬の内服(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban41(), entity.getZenkaiChosaItemKoban35(), entity.getZenkaiChosaItemKoban57()));
        csvEntity.set前回結果_金銭の管理(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban42(), entity.getZenkaiChosaItemKoban36(), entity.getZenkaiChosaItemKoban58()));
        csvEntity.set前回結果_日常の意思決定(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban38(), entity.getZenkaiChosaItemKoban59()));
        csvEntity.set前回結果_集団への不適応(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban60()));
        csvEntity.set前回結果_買い物(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban61()));
        csvEntity.set前回結果_簡単な調理(get項目By厚労省99Aと02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                RString.EMPTY, entity.getZenkaiChosaItemKoban62()));
        csvEntity.set前回結果_点滴の管理(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban74(), entity.getZenkaiChosaItemKoban68(), entity.getZenkaiChosaItemKoban63()));
        csvEntity.set前回結果_中心静脈栄養(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban75(), entity.getZenkaiChosaItemKoban69(), entity.getZenkaiChosaItemKoban64()));
        csvEntity.set前回結果_透析(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban76(), entity.getZenkaiChosaItemKoban70(), entity.getZenkaiChosaItemKoban65()));
        csvEntity.set前回結果_ストーマの処置(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban77(), entity.getZenkaiChosaItemKoban71(), entity.getZenkaiChosaItemKoban66()));
        csvEntity.set前回結果_酸素療法(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban78(), entity.getZenkaiChosaItemKoban72(), entity.getZenkaiChosaItemKoban67()));
        csvEntity.set前回結果_レスピレーター(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban79(), entity.getZenkaiChosaItemKoban73(), entity.getZenkaiChosaItemKoban68()));
        csvEntity.set前回結果_気管切開の処置(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban80(), entity.getZenkaiChosaItemKoban74(), entity.getZenkaiChosaItemKoban69()));
        csvEntity.set前回結果_疼痛の看護(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban81(), entity.getZenkaiChosaItemKoban75(), entity.getZenkaiChosaItemKoban70()));
        csvEntity.set前回結果_経管栄養(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban82(), entity.getZenkaiChosaItemKoban76(), entity.getZenkaiChosaItemKoban71()));
        csvEntity.set前回結果_モニター測定(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban83(), entity.getZenkaiChosaItemKoban77(), entity.getZenkaiChosaItemKoban72()));
        csvEntity.set前回結果_じょくそうの処置(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban84(), entity.getZenkaiChosaItemKoban78(), entity.getZenkaiChosaItemKoban73()));
        csvEntity.set前回結果_カテーテル(get項目By厚労省99ABy02Aと06A(entity.getZenkaiKoroshoIfShikibetsuCode(),
                entity.getZenkaiChosaItemKoban85(), entity.getZenkaiChosaItemKoban79(), entity.getZenkaiChosaItemKoban74()));
    }

    private void initializeサービスの状況(CenterTransmissionCsvEntity csvEntity) {
        csvEntity.set介護予防訪問介護ホームヘルプサービス(EMPTY_VALUE);
        csvEntity.set介護予防訪問入浴介護(EMPTY_VALUE);
        csvEntity.set介護予防訪問看護(EMPTY_VALUE);
        csvEntity.set介護予防訪問リハビリテーション(EMPTY_VALUE);
        csvEntity.set介護予防居宅療養管理指導(EMPTY_VALUE);
        csvEntity.set介護予防通所介護デイサービス(EMPTY_VALUE);
        csvEntity.set介護予防通所リハビリテーション(EMPTY_VALUE);
        csvEntity.set介護予防短期入所生活介護ショートステイ(EMPTY_VALUE);
        csvEntity.set介護予防短期入所療養介護(EMPTY_VALUE);
        csvEntity.set介護予防特定施設入居者生活介護(EMPTY_VALUE);
        csvEntity.set介護予防福祉用具貸与(EMPTY_VALUE);
        csvEntity.set特定介護予防福祉用具販売(EMPTY_VALUE);
        csvEntity.set住宅改修予防給付(getValue(false));
        csvEntity.set介護予防認知症対応型通所介護(EMPTY_VALUE);
        csvEntity.set介護予防小規模多機能型居宅介護(EMPTY_VALUE);
        csvEntity.set介護予防認知症対応型共同生活介護グループホーム(EMPTY_VALUE);

        csvEntity.set訪問介護ホームヘルプサービス(EMPTY_VALUE);
        csvEntity.set訪問入浴介護(EMPTY_VALUE);
        csvEntity.set訪問看護(EMPTY_VALUE);
        csvEntity.set訪問リハビリテーション(EMPTY_VALUE);
        csvEntity.set居宅療養管理指導(EMPTY_VALUE);
        csvEntity.set通所介護デイサービス(EMPTY_VALUE);
        csvEntity.set通所リハビリテーション(EMPTY_VALUE);
        csvEntity.set短期入所生活介護ショートステイ(EMPTY_VALUE);
        csvEntity.set短期入所療養介護(EMPTY_VALUE);
        csvEntity.set特定施設入居者生活介護(EMPTY_VALUE);
        csvEntity.set福祉用具貸与(EMPTY_VALUE);
        csvEntity.set特定福祉用具販売(EMPTY_VALUE);
        csvEntity.set住宅改修介護給付(getValue(false));
        csvEntity.set夜間対応型訪問介護(EMPTY_VALUE);
        csvEntity.set認知症対応型通所介護(EMPTY_VALUE);
        csvEntity.set小規模多機能型居宅介護(EMPTY_VALUE);
        csvEntity.set認知症対応型共同生活介護グループホーム(EMPTY_VALUE);
        csvEntity.set地域密着型特定施設入居者生活介護(EMPTY_VALUE);
        csvEntity.set地域密着型介護老人福祉施設入所者生活介護(EMPTY_VALUE);
        csvEntity.set定期巡回随時対応型訪問介護看護(EMPTY_VALUE);
        csvEntity.set複合型サービス(EMPTY_VALUE);
    }

    private void initialize前回サービスの状況(CenterTransmissionCsvEntity csvEntity) {
        csvEntity.set前回結果_介護予防訪問介護ホームヘルプサービス(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防訪問入浴介護(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防訪問看護(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防訪問リハビリテーション(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防居宅療養管理指導(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防通所介護デイサービス(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防通所リハビリテーション(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防短期入所生活介護ショートステイ(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防短期入所療養介護(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防特定施設入居者生活介護(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防福祉用具貸与(EMPTY_VALUE);
        csvEntity.set前回結果_特定介護予防福祉用具販売(EMPTY_VALUE);
        csvEntity.set前回結果_住宅改修予防給付(getValue(false));
        csvEntity.set前回結果_介護予防認知症対応型通所介護(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防小規模多機能型居宅介護(EMPTY_VALUE);
        csvEntity.set前回結果_介護予防認知症対応型共同生活介護グループホーム(EMPTY_VALUE);

        csvEntity.set前回結果_訪問介護ホームヘルプサービス(EMPTY_VALUE);
        csvEntity.set前回結果_訪問入浴介護(EMPTY_VALUE);
        csvEntity.set前回結果_訪問看護(EMPTY_VALUE);
        csvEntity.set前回結果_訪問リハビリテーション(EMPTY_VALUE);
        csvEntity.set前回結果_居宅療養管理指導(EMPTY_VALUE);
        csvEntity.set前回結果_通所介護デイサービス(EMPTY_VALUE);
        csvEntity.set前回結果_通所リハビリテーション(EMPTY_VALUE);
        csvEntity.set前回結果_短期入所生活介護ショートステイ(EMPTY_VALUE);
        csvEntity.set前回結果_短期入所療養介護(EMPTY_VALUE);
        csvEntity.set前回結果_特定施設入居者生活介護(EMPTY_VALUE);
        csvEntity.set前回結果_福祉用具貸与(EMPTY_VALUE);
        csvEntity.set前回結果_特定福祉用具販売(EMPTY_VALUE);
        csvEntity.set前回結果_住宅改修介護給付(getValue(false));
        csvEntity.set前回結果_夜間対応型訪問介護(EMPTY_VALUE);
        csvEntity.set前回結果_認知症対応型通所介護(EMPTY_VALUE);
        csvEntity.set前回結果_小規模多機能型居宅介護(EMPTY_VALUE);
        csvEntity.set前回結果_認知症対応型共同生活介護グループホーム(EMPTY_VALUE);
        csvEntity.set前回結果_地域密着型特定施設入居者生活介護(EMPTY_VALUE);
        csvEntity.set前回結果_地域密着型介護老人福祉施設入所者生活介護(EMPTY_VALUE);
        csvEntity.set前回結果_定期巡回随時対応型訪問介護看護(EMPTY_VALUE);
        csvEntity.set前回結果_複合型サービス(EMPTY_VALUE);
    }

    private RString getValue(Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString getValue(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private RString getValue(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

    private RString get番号(ShujiiIryokikanCode code) {
        if (code == null) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString get番号(ShujiiCode code) {
        if (code == null) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString get番号(JigyoshaNo code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString get名称(AtenaMeisho code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString get名称(AtenaJusho code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString get調査委託区分(RString code) {

        for (ChosaItakuKubunCode chosaItakuKubunCode : ChosaItakuKubunCode.values()) {
            if (chosaItakuKubunCode.getコード().equals(code)) {
                return ChosaItakuKubunCode.toValue(code).get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString get項目By厚労省99Aと02A(Code 厚労省IF識別コード, RString 項番1, RString 項番2) {
        if (厚労省IF識別コード == null || 厚労省IF識別コード.isEmpty()) {
            return RString.EMPTY;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            return 項番1;
        }
        return 項番2;
    }

    private RString get項目By厚労省99Aと02Aと06A(Code 厚労省IF識別コード, RString 項番1, RString 項番2) {
        if (厚労省IF識別コード == null || 厚労省IF識別コード.isEmpty()) {
            return RString.EMPTY;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            return 項番1;
        }
        return 項番2;
    }

    private RString get項目By厚労省99ABy02Aと06A(Code 厚労省IF識別コード, RString 項番1, RString 項番2, RString 項番3) {
        if (厚労省IF識別コード == null || 厚労省IF識別コード.isEmpty()) {
            return RString.EMPTY;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            return 項番1;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            return 項番2;
        }
        return 項番3;
    }

    private RString get項目By厚労省99Aと02ABy06A(Code 厚労省IF識別コード, RString 項番1, RString 項番2, RString 項番3) {
        if (厚労省IF識別コード == null || 厚労省IF識別コード.isEmpty()) {
            return RString.EMPTY;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            return 項番1;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            return 項番2;
        }
        return 項番3;
    }

    private RString get項目By厚労省99B以外(Code 厚労省IF識別コード, RString 項番) {
        if (厚労省IF識別コード == null || 厚労省IF識別コード.isEmpty()) {
            return RString.EMPTY;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            return 項番;
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            return EMPTY_VALUE;
        }
        return RString.EMPTY;
    }

    private RString getValue(boolean isServiceJokyoFlag) {
        if (isServiceJokyoFlag) {
            return new RString("1");
        }
        return new RString("2");
    }
}
