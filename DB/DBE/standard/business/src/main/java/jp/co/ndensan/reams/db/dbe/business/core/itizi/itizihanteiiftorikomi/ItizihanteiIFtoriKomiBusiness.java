/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.itizi.itizihanteiiftorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itizihanteiiftorikomi.IchijiHanteiKekkaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itizihanteiiftorikomi.ItizihanteiIFtoriKomiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.GaizenseiHyokaCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBE309002_一次判定IF取込のBusinessクラスです。
 *
 * @reamsid_L DBE-1470-022 wanghui
 */
public class ItizihanteiIFtoriKomiBusiness {

    private static final Code 認定ｿﾌﾄ99 = new Code(new RString("99A"));
    private static final Code 認定ｿﾌﾄ2009_A = new Code(new RString("09A"));
    private static final Code 認定ｿﾌﾄ2009_B = new Code(new RString("09B"));

    /**
     * 一一時テーブル処理。
     *
     * @param temoTableEntity IchijiHanteiKekkaJohoTempTableEntity
     * @param entity IchijiHanteizumIfOutputEucCsvEntity
     * @param 結果コード RString
     * @return temoTableEntity
     */
    public IchijiHanteiKekkaJohoTempTableEntity set一時テーブル(IchijiHanteiKekkaJohoTempTableEntity temoTableEntity,
            IchijiHanteizumIfOutputEucCsvEntity entity, RString 結果コード) {
        temoTableEntity.setShinseishoKanriNo(entity.get保険者番号());
        temoTableEntity.setHihokenshaNo(entity.get被保険者番号());
        temoTableEntity.setNinteiShinseiYMD(entity.get認定申請日());
        temoTableEntity.setNinteiShinseiShinseijiKubunCode(entity.get申請区分申請時コード());
        temoTableEntity.setIchijiHanteiKekkaCode(結果コード);
        temoTableEntity.setIchijiHanteiKekkaNinchishoKasanCode(entity.get一次判定結果認知症加算());
        temoTableEntity.setKijunJikan(entity.get要介護認定等基準時間());
        temoTableEntity.setKijunJikanShokuji(entity.get要介護認定等基準時間食事());
        temoTableEntity.setKijunJikanHaisetsu(entity.get要介護認定等基準時間排泄());
        temoTableEntity.setKijunJikanIdo(entity.get要介護認定等基準時間移動());
        temoTableEntity.setKijunJikanSeiketsuHoji(entity.get要介護認定等基準時間清潔保持());
        temoTableEntity.setKijunJikanKansetsuCare(entity.get要介護認定等基準時間間接ケア());
        temoTableEntity.setKijunJikanBPSDKanren(entity.get要介護認定等基準時間BPSD関連());
        temoTableEntity.setKijunJikanKinoKunren(entity.get要介護認定等基準時間機能訓練());
        temoTableEntity.setKijunJikanIryoKanren(entity.get要介護認定等基準時間医療関連());
        temoTableEntity.setKijunJikanNinchishoKasan(entity.get要介護認定等基準時間認知症加算());
        temoTableEntity.setChukanHyokaKomoku1gun(entity.get中間評価項目得点第１群());
        temoTableEntity.setChukanHyokaKomoku2gun(entity.get中間評価項目得点第２群());
        temoTableEntity.setChukanHyokaKomoku3gun(entity.get中間評価項目得点第３群());
        temoTableEntity.setChukanHyokaKomoku4gun(entity.get中間評価項目得点第４群());
        temoTableEntity.setChukanHyokaKomoku5gun(entity.get中間評価項目得点第５群());
        temoTableEntity.setIchijiHnateiKeikokuCode(entity.get一次判定警告配列コード());
        temoTableEntity.setJotaiAnteiseiCode(entity.get状態の安定性());
        temoTableEntity.setNinchishoJiritsudoIIijoNoGaizensei(entity.get認知症自立度Ⅱ以上の蓋然性());
        temoTableEntity.setSuiteiKyufuKubunCode(entity.get認知機能及び状態安定性から推定される給付区分());
        return temoTableEntity;
    }

    /**
     * 一次判定結果情報情報登録処理。
     *
     * @param entity IchijiHanteizumIfOutputEucCsvEntity
     * @return dbt5010Entity
     */
    public DbT5116IchijiHanteiKekkaJohoEntity getchijiHanteiKekkaJoho(ItizihanteiIFtoriKomiRelateEntity entity) {
        DbT5116IchijiHanteiKekkaJohoEntity dbt5010Entity = new DbT5116IchijiHanteiKekkaJohoEntity();
        dbt5010Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.getShinseishoKanriNo()));
        dbt5010Entity.setKariIchijiHanteiKubun(true);
        dbt5010Entity.setIchijiHanteiYMD(new FlexibleDate(RDate.getNowDate().toString()));
        if (認定ｿﾌﾄ99.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaCode(new Code(entity.getIchijiHanteiKekkaCode()));
        } else if (認定ｿﾌﾄ2009_A.value().equals(entity.getKoroshoIfShikibetsuCode())
                && 認定ｿﾌﾄ2009_B.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaCode(new Code(entity.getIchijiHanteiKekkaCode()));
        }
        if (認定ｿﾌﾄ99.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaNinchishoKasanCode(new Code(entity.getIchijiHanteiKekkaCode()));
        } else if (認定ｿﾌﾄ2009_A.value().equals(entity.getKoroshoIfShikibetsuCode())
                && 認定ｿﾌﾄ2009_B.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaNinchishoKasanCode(new Code(entity.getIchijiHanteiKekkaCode()));
        }
        dbt5010Entity.setKijunJikan(Integer.parseInt(entity.getKijunJikan().toString()));
        dbt5010Entity.setKijunJikanShokuji(Integer.parseInt(entity.getKijunJikanShokuji().toString()));
        dbt5010Entity.setKijunJikanHaisetsu(Integer.parseInt(entity.getKijunJikanHaisetsu().toString()));
        dbt5010Entity.setKijunJikanIdo(Integer.parseInt(entity.getKijunJikanIdo().toString()));
        dbt5010Entity.setKijunJikanSeiketsuHoji(Integer.parseInt(entity.getKijunJikanSeiketsuHoji().toString()));
        dbt5010Entity.setKijunJikanKansetsuCare(Integer.parseInt(entity.getKijunJikanKansetsuCare().toString()));
        dbt5010Entity.setKijunJikanBPSDKanren(Integer.parseInt(entity.getKijunJikanBPSDKanren().toString()));
        dbt5010Entity.setKijunJikanKinoKunren(Integer.parseInt(entity.getKijunJikanKinoKunren().toString()));
        dbt5010Entity.setKijunJikanIryoKanren(Integer.parseInt(entity.getKijunJikanIryoKanren().toString()));
        dbt5010Entity.setKijunJikanNinchishoKasan(Integer.parseInt(entity.getKijunJikanNinchishoKasan().toString()));
        dbt5010Entity.setChukanHyokaKomoku1gun(Integer.parseInt(entity.getChukanHyokaKomoku1gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku2gun(Integer.parseInt(entity.getChukanHyokaKomoku2gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku3gun(Integer.parseInt(entity.getChukanHyokaKomoku3gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku4gun(Integer.parseInt(entity.getChukanHyokaKomoku4gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku5gun(Integer.parseInt(entity.getChukanHyokaKomoku5gun().toString()));
        dbt5010Entity.setIchijiHnateiKeikokuCode(entity.getIchijiHnateiKeikokuCode());
        dbt5010Entity.setJotaiAnteiseiCode(new Code(JotaiAnteiseiCode.valueOf(entity.getJotaiAnteiseiCode().toString()).getコード()));
        dbt5010Entity.setNinchishoJiritsudoIIijoNoGaizensei(new Decimal(entity.getNinchishoJiritsudoIIijoNoGaizensei().toString()));
        dbt5010Entity.setSuiteiKyufuKubunCode(new Code(SuiteiKyufuKubunCode.valueOf(entity.getSuiteiKyufuKubunCode().toString()).getコード()));
        return dbt5010Entity;
    }

    /**
     * 一次判定結果情報情報更新処理です。
     *
     * @param entity IchijiHanteizumIfOutputEucCsvEntity
     * @return dbt5010Entity
     */
    public DbT5116IchijiHanteiKekkaJohoEntity get更新処理(ItizihanteiIFtoriKomiRelateEntity entity) {
        DbT5116IchijiHanteiKekkaJohoEntity dbt5010Entity = new DbT5116IchijiHanteiKekkaJohoEntity();
        dbt5010Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.getShinseishoKanriNo().toString()));
        dbt5010Entity.setIchijiHanteiYMD(new FlexibleDate(RDate.getNowDate().toString()));
        if (認定ｿﾌﾄ99.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaCode(new Code(entity.getIchijiHanteiKekkaCode()));
        } else if (認定ｿﾌﾄ2009_A.value().equals(entity.getKoroshoIfShikibetsuCode())
                && 認定ｿﾌﾄ2009_B.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaCode(new Code(entity.getIchijiHanteiKekkaCode()));
        }
        if (認定ｿﾌﾄ99.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaNinchishoKasanCode(new Code(IchijiHanteiKekkaCode99
                    .valueOf(entity.getIchijiHanteiKekkaCode().toString()).toString()));
        } else if (認定ｿﾌﾄ2009_A.value().equals(entity.getKoroshoIfShikibetsuCode())
                && 認定ｿﾌﾄ2009_B.value().equals(entity.getKoroshoIfShikibetsuCode())) {
            dbt5010Entity.setIchijiHanteiKekkaNinchishoKasanCode(new Code(entity.getIchijiHanteiKekkaCode()));
        }
        dbt5010Entity.setKijunJikan(Integer.parseInt(entity.getKijunJikan().toString()));
        dbt5010Entity.setKijunJikanShokuji(Integer.parseInt(entity.getKijunJikanShokuji().toString()));
        dbt5010Entity.setKijunJikanHaisetsu(Integer.parseInt(entity.getKijunJikanHaisetsu().toString()));
        dbt5010Entity.setKijunJikanIdo(Integer.parseInt(entity.getKijunJikanIdo().toString()));
        dbt5010Entity.setKijunJikanSeiketsuHoji(Integer.parseInt(entity.getKijunJikanSeiketsuHoji().toString()));
        dbt5010Entity.setKijunJikanKansetsuCare(Integer.parseInt(entity.getKijunJikanKansetsuCare().toString()));
        dbt5010Entity.setKijunJikanBPSDKanren(Integer.parseInt(entity.getKijunJikanBPSDKanren().toString()));
        dbt5010Entity.setKijunJikanKinoKunren(Integer.parseInt(entity.getKijunJikanKinoKunren().toString()));
        dbt5010Entity.setKijunJikanIryoKanren(Integer.parseInt(entity.getKijunJikanIryoKanren().toString()));
        dbt5010Entity.setKijunJikanNinchishoKasan(Integer.parseInt(entity.getKijunJikanNinchishoKasan().toString()));
        dbt5010Entity.setChukanHyokaKomoku1gun(Integer.parseInt(entity.getChukanHyokaKomoku1gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku2gun(Integer.parseInt(entity.getChukanHyokaKomoku2gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku3gun(Integer.parseInt(entity.getChukanHyokaKomoku3gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku4gun(Integer.parseInt(entity.getChukanHyokaKomoku4gun().toString()));
        dbt5010Entity.setChukanHyokaKomoku5gun(Integer.parseInt(entity.getChukanHyokaKomoku5gun().toString()));
        dbt5010Entity.setIchijiHnateiKeikokuCode(entity.getIchijiHnateiKeikokuCode());
        dbt5010Entity.setJotaiAnteiseiCode(new Code(JotaiAnteiseiCode.toValue(entity.getJotaiAnteiseiCode()).getコード().toString()));
        dbt5010Entity.setNinchishoJiritsudoIIijoNoGaizensei(new Decimal(GaizenseiHyokaCode.toValue(entity.getNinchishoJiritsudoIIijoNoGaizensei())
                .getコード().toString()));
        dbt5010Entity.setSuiteiKyufuKubunCode(new Code(SuiteiKyufuKubunCode.toValue(entity.getSuiteiKyufuKubunCode())
                .getコード()));
        return dbt5010Entity;
    }

    /**
     * 取込みファイルの必須項目チェック処理。
     *
     * @param entity IchijiHanteizumIfOutputEucCsvEntity
     * @return 連携対象項目一覧判定
     */
    public boolean 連携対象項目一覧判定(IchijiHanteizumIfOutputEucCsvEntity entity) {
        boolean 連携対象項目一覧判定 = false;
        if ((連携対象項目一覧Null(entity))
                || (項目の空判定(entity))
                || (項目の空判定_2(entity))
                || (項目の空判定_3(entity))
                || (項目の空判定_4(entity))
                || (項目の空判定_5(entity))
                || (項目の空判定_6(entity))
                || (項目の空判定_7(entity))
                || (項目の空判定_8(entity))
                || (項目の空判定_9(entity))) {
            連携対象項目一覧判定 = true;
        }
        return 連携対象項目一覧判定;
    }

    private boolean 連携対象項目一覧Null(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get中心静脈栄養())
                || RString.isNullOrEmpty(entity.get透析())
                || RString.isNullOrEmpty(entity.getストーマの処置())
                || RString.isNullOrEmpty(entity.get酸素療法())
                || RString.isNullOrEmpty(entity.getレスピレーター())
                || RString.isNullOrEmpty(entity.get気管切開の処置())
                || RString.isNullOrEmpty(entity.get疼痛の看護())
                || RString.isNullOrEmpty(entity.get経管栄養())
                || RString.isNullOrEmpty(entity.getモニター測定())
                || RString.isNullOrEmpty(entity.getじょくそうの処置())
                || RString.isNullOrEmpty(entity.getカテーテル())
                || RString.isNullOrEmpty(entity.get障害高齢者自立度())
                || RString.isNullOrEmpty(entity.get認知症高齢者自立度());

    }

    private boolean 項目の空判定_6(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get昼夜逆転())
                || RString.isNullOrEmpty(entity.get同じ話をする())
                || RString.isNullOrEmpty(entity.get大声を出す())
                || RString.isNullOrEmpty(entity.get介護に抵抗())
                || RString.isNullOrEmpty(entity.get落ち着きなし())
                || RString.isNullOrEmpty(entity.get一人で出たがる())
                || RString.isNullOrEmpty(entity.get収集癖())
                || RString.isNullOrEmpty(entity.get物や衣類を壊す())
                || RString.isNullOrEmpty(entity.getひどい物忘れ())
                || RString.isNullOrEmpty(entity.get独り言独り笑い())
                || RString.isNullOrEmpty(entity.get自分勝手に行動する())
                || RString.isNullOrEmpty(entity.get話がまとまらない())
                || RString.isNullOrEmpty(entity.get薬の内服())
                || RString.isNullOrEmpty(entity.get金銭の管理())
                || RString.isNullOrEmpty(entity.get日常の意思決定())
                || RString.isNullOrEmpty(entity.get集団への不適応())
                || RString.isNullOrEmpty(entity.get買い物())
                || RString.isNullOrEmpty(entity.get簡単な調理())
                || RString.isNullOrEmpty(entity.get点滴の管理());
    }

    private boolean 項目の空判定_7(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.getシーケンシャル番号())
                || RString.isNullOrEmpty(entity.get識別コード())
                || RString.isNullOrEmpty(entity.get保険者番号())
                || RString.isNullOrEmpty(entity.get被保険者番号())
                || RString.isNullOrEmpty(entity.get認定申請日())
                || RString.isNullOrEmpty(entity.get枝番())
                || RString.isNullOrEmpty(entity.get申請区分法令コード())
                || RString.isNullOrEmpty(entity.get申請区分申請時コード())
                || RString.isNullOrEmpty(entity.get取下区分コード())
                || RString.isNullOrEmpty(entity.get被保険者区分コード())
                || RString.isNullOrEmpty(entity.get申請代行区分コード())
                || RString.isNullOrEmpty(entity.get生年月日())
                || RString.isNullOrEmpty(entity.get年齢())
                || RString.isNullOrEmpty(entity.get性別コード())
                || RString.isNullOrEmpty(entity.get前回の認定審査会結果())
                || RString.isNullOrEmpty(entity.get主治医医療機関番号());
    }

    private boolean 項目の空判定_5(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get排便())
                || RString.isNullOrEmpty(entity.get口腔清潔())
                || RString.isNullOrEmpty(entity.get洗顔())
                || RString.isNullOrEmpty(entity.get整髪())
                || RString.isNullOrEmpty(entity.get上衣の着脱())
                || RString.isNullOrEmpty(entity.getズボン等の着脱())
                || RString.isNullOrEmpty(entity.get外出頻度())
                || RString.isNullOrEmpty(entity.get意思の伝達())
                || RString.isNullOrEmpty(entity.get毎日の日課を理解())
                || RString.isNullOrEmpty(entity.get生年月日をいう())
                || RString.isNullOrEmpty(entity.get短期記憶())
                || RString.isNullOrEmpty(entity.get自分の名前をいう())
                || RString.isNullOrEmpty(entity.get今の季節を理解())
                || RString.isNullOrEmpty(entity.get場所の理解())
                || RString.isNullOrEmpty(entity.get徘徊())
                || RString.isNullOrEmpty(entity.get外出して戻れない())
                || RString.isNullOrEmpty(entity.get被害的())
                || RString.isNullOrEmpty(entity.get作話())
                || RString.isNullOrEmpty(entity.get感情が不安定());
    }

    private boolean 項目の空判定_4(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get拘縮股関節())
                || RString.isNullOrEmpty(entity.get拘縮膝関節())
                || RString.isNullOrEmpty(entity.get拘縮その他())
                || RString.isNullOrEmpty(entity.get寝返り())
                || RString.isNullOrEmpty(entity.get起き上がり())
                || RString.isNullOrEmpty(entity.get座位保持())
                || RString.isNullOrEmpty(entity.get両足での立位())
                || RString.isNullOrEmpty(entity.get歩行())
                || RString.isNullOrEmpty(entity.get立ち上がり())
                || RString.isNullOrEmpty(entity.get片足での立位())
                || RString.isNullOrEmpty(entity.get洗身())
                || RString.isNullOrEmpty(entity.getつめ切り())
                || RString.isNullOrEmpty(entity.get視力())
                || RString.isNullOrEmpty(entity.get聴力())
                || RString.isNullOrEmpty(entity.get移乗())
                || RString.isNullOrEmpty(entity.get移動())
                || RString.isNullOrEmpty(entity.getえん下())
                || RString.isNullOrEmpty(entity.get食事摂取())
                || RString.isNullOrEmpty(entity.get排尿());
    }

    private boolean 項目の空判定_3(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get介護予防居宅療養管理指導())
                || RString.isNullOrEmpty(entity.get介護予防通所介護デイサービス())
                || RString.isNullOrEmpty(entity.get介護予防通所リハビリテーション())
                || RString.isNullOrEmpty(entity.get介護予防短期入所生活介護ショートステイ())
                || RString.isNullOrEmpty(entity.get介護予防短期入所療養介護())
                || RString.isNullOrEmpty(entity.get介護予防特定施設入居者生活介護())
                || RString.isNullOrEmpty(entity.get介護予防福祉用具貸与())
                || RString.isNullOrEmpty(entity.get特定介護予防福祉用具販売())
                || RString.isNullOrEmpty(entity.get住宅改修予防給付())
                || RString.isNullOrEmpty(entity.get介護予防認知症対応型通所介護())
                || RString.isNullOrEmpty(entity.get介護予防小規模多機能型居宅介護())
                || RString.isNullOrEmpty(entity.get介護予防認知症対応型共同生活介護グループホーム())
                || RString.isNullOrEmpty(entity.get麻痺左上肢())
                || RString.isNullOrEmpty(entity.get麻痺右上肢())
                || RString.isNullOrEmpty(entity.get麻痺左下肢())
                || RString.isNullOrEmpty(entity.get麻痺右下肢())
                || RString.isNullOrEmpty(entity.get麻痺その他())
                || RString.isNullOrEmpty(entity.get拘縮肩関節());
    }

    private boolean 項目の空判定_2(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get短期入所生活介護ショートステイ())
                || RString.isNullOrEmpty(entity.get短期入所療養介護())
                || RString.isNullOrEmpty(entity.get特定施設入居者生活介護())
                || RString.isNullOrEmpty(entity.get福祉用具貸与())
                || RString.isNullOrEmpty(entity.get特定福祉用具販売())
                || RString.isNullOrEmpty(entity.get住宅改修介護給付())
                || RString.isNullOrEmpty(entity.get夜間対応型訪問介護())
                || RString.isNullOrEmpty(entity.get認知症対応型通所介護())
                || RString.isNullOrEmpty(entity.get小規模多機能型居宅介護())
                || RString.isNullOrEmpty(entity.get認知症対応型共同生活介護グループホーム())
                || RString.isNullOrEmpty(entity.get地域密着型特定施設入居者生活介護())
                || RString.isNullOrEmpty(entity.get地域密着型介護老人福祉施設入所者生活介護())
                || RString.isNullOrEmpty(entity.get定期巡回随時対応型訪問介護看護())
                || RString.isNullOrEmpty(entity.get複合型サービス())
                || RString.isNullOrEmpty(entity.get介護予防訪問介護ホームヘルプサービス())
                || RString.isNullOrEmpty(entity.get介護予防訪問入浴介護())
                || RString.isNullOrEmpty(entity.get介護予防訪問看護())
                || RString.isNullOrEmpty(entity.get介護予防訪問リハビリテーション());
    }

    private boolean 項目の空判定(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get中間評価項目得点第１群())
                || RString.isNullOrEmpty(entity.get中間評価項目得点第２群())
                || RString.isNullOrEmpty(entity.get中間評価項目得点第３群())
                || RString.isNullOrEmpty(entity.get中間評価項目得点第４群())
                || RString.isNullOrEmpty(entity.get中間評価項目得点第５群())
                || RString.isNullOrEmpty(entity.get一次判定警告配列コード())
                || RString.isNullOrEmpty(entity.get状態の安定性())
                || RString.isNullOrEmpty(entity.get認知症自立度Ⅱ以上の蓋然性())
                || RString.isNullOrEmpty(entity.get認知機能及び状態安定性から推定される給付区分())
                || RString.isNullOrEmpty(entity.get現在のサービス区分コード())
                || RString.isNullOrEmpty(entity.get現在の状況())
                || RString.isNullOrEmpty(entity.get訪問介護ホームヘルプサービス())
                || RString.isNullOrEmpty(entity.get訪問入浴介護())
                || RString.isNullOrEmpty(entity.get訪問看護())
                || RString.isNullOrEmpty(entity.get訪問リハビリテーション())
                || RString.isNullOrEmpty(entity.get居宅療養管理指導())
                || RString.isNullOrEmpty(entity.get通所介護デイサービス())
                || RString.isNullOrEmpty(entity.get通所リハビリテーション());
    }

    private boolean 項目の空判定_8(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get要介護認定等基準時間())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間食事())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間排泄())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間移動())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間清潔保持())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間間接ケア())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間BPSD関連())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間機能訓練())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間医療関連())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間認知症加算());
    }

    private boolean 項目の空判定_9(IchijiHanteizumIfOutputEucCsvEntity entity) {
        return RString.isNullOrEmpty(entity.get意見書依頼日())
                || RString.isNullOrEmpty(entity.get意見書入手日())
                || RString.isNullOrEmpty(entity.get意見書短期記憶())
                || RString.isNullOrEmpty(entity.get意見書認知能力())
                || RString.isNullOrEmpty(entity.get意見書伝達能力())
                || RString.isNullOrEmpty(entity.get意見書食事行為())
                || RString.isNullOrEmpty(entity.get意見書認知症高齢者の日常生活自立度())
                || RString.isNullOrEmpty(entity.get調査依頼日())
                || RString.isNullOrEmpty(entity.get調査実施日())
                || RString.isNullOrEmpty(entity.get指定居宅介護支援事業者等番号())
                || RString.isNullOrEmpty(entity.get一次判定日())
                || RString.isNullOrEmpty(entity.get一次判定結果())
                || RString.isNullOrEmpty(entity.get一次判定結果認知症加算())
                || RString.isNullOrEmpty(entity.get要介護認定等基準時間());
    }

    /**
     * 一要介護認定一次判定結果処理です。
     *
     * @param 一次判定結果名称 一次判定結果名称
     * @return RString
     */
    public RString 要介護認定一次判定結果コードの名称(RString 一次判定結果名称) {
        RString 一次判定 = 要介護認定一次判定結果コード99の名称(一次判定結果名称);
        if (!一次判定.isEmpty()) {
            return 一次判定;
        }
        RString コード09 = 要介護認定一次判定結果コード09の名称(一次判定結果名称);
        if (コード09.isEmpty()) {
            return コード09;
        }
        return RString.EMPTY;
    }

    private RString 要介護認定一次判定結果コード99の名称(RString 一次判定結果名称) {
        if (IchijiHanteiKekkaCode99.みなし要支援.get名称().equals(一次判定結果名称)) {

            return IchijiHanteiKekkaCode99.みなし要支援.getコード();
        } else if (IchijiHanteiKekkaCode99.みなし非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.みなし非該当.getコード();
        } else if (IchijiHanteiKekkaCode99.経過的要介護.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.経過的要介護.getコード();
        } else if (IchijiHanteiKekkaCode99.要介護1.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護1.getコード();
        } else if (IchijiHanteiKekkaCode99.要介護2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護2.getコード();
        } else if (IchijiHanteiKekkaCode99.要介護3.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護3.getコード();
        } else if (IchijiHanteiKekkaCode99.要介護4.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護4.getコード();
        } else if (IchijiHanteiKekkaCode99.要介護5.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護5.getコード();
        } else if (IchijiHanteiKekkaCode99.非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.非該当.getコード();
        }
        return RString.EMPTY;
    }

    private RString 要介護認定一次判定結果コード09の名称(RString 一次判定結果名称) {
        if (IchijiHanteiKekkaCode09.要介護1.get名称().equals(一次判定結果名称)) {

            return IchijiHanteiKekkaCode09.要介護1.getコード();
        } else if (IchijiHanteiKekkaCode09.要介護2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護2.getコード();
        } else if (IchijiHanteiKekkaCode09.要介護3.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護3.getコード();
        } else if (IchijiHanteiKekkaCode09.要介護4.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護4.getコード();
        } else if (IchijiHanteiKekkaCode09.要介護5.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護5.getコード();
        } else if (IchijiHanteiKekkaCode09.送付済.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.送付済.getコード();
        } else if (IchijiHanteiKekkaCode09.非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.非該当.getコード();
        } else if (IchijiHanteiKekkaCode09.要支援2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要支援2.getコード();
        }
        return RString.EMPTY;
    }
}
