/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定一次判定結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5116IchijiHanteiKekkaJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final boolean DEFAULT_仮一次判定区分 = false;
    public static final FlexibleDate DEFAULT_要介護認定一次判定年月日 = new FlexibleDate("20150402");
    public static final Code DEFAULT_要介護認定一次判定結果コード = new Code("1");
    public static final Code DEFAULT_要介護認定一次判定結果コード_認知症加算_ = new Code("1");
    public static final int DEFAULT_要介護認定等基準時間 = 1;
    public static final int DEFAULT_要介護認定等基準時間_食事_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_排泄_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_移動_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_清潔保持_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_間接ケア_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_BPSD関連_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_機能訓練_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_医療関連_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_認知症加算_ = 1;
    public static final int DEFAULT_中間評価項目得点第1群 = 1;
    public static final int DEFAULT_中間評価項目得点第2群 = 1;
    public static final int DEFAULT_中間評価項目得点第3群 = 1;
    public static final int DEFAULT_中間評価項目得点第4群 = 1;
    public static final int DEFAULT_中間評価項目得点第5群 = 1;
    public static final int DEFAULT_中間評価項目得点第6群 = 1;
    public static final int DEFAULT_中間評価項目得点第7群 = 1;
    public static final Code DEFAULT_要介護認定一次判定警告コード = new Code("1");
    public static final Code DEFAULT_要介護認定状態の安定性コード = new Code("1");
    public static final Decimal DEFAULT_認知症自立度Ⅱ以上の蓋然性 = new Decimal("1");
    public static final Code DEFAULT_認知機能及び状態安定性から推定される給付区分コード = new Code("1");
    public static final Code DEFAULT_運動能力の低下していない認知症高齢者の指標コード = new Code("1");
    public static final int DEFAULT_日常生活自立度の組み合わせ_自立_ = 1;
    public static final int DEFAULT_日常生活自立度の組み合わせ_要支援_ = 1;
    public static final int DEFAULT_日常生活自立度の組み合わせ_要介護１_ = 1;
    public static final int DEFAULT_日常生活自立度の組み合わせ_要介護２_ = 1;
    public static final int DEFAULT_日常生活自立度の組み合わせ_要介護３_ = 1;
    public static final int DEFAULT_日常生活自立度の組み合わせ_要介護４_ = 1;
    public static final int DEFAULT_日常生活自立度の組み合わせ_要介護５_ = 1;
    public static final Code DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価コード = new Code("1");
    public static final int DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価 = 1;
    public static final RString DEFAULT_一次判定結果送付区分 = new RString("1");
    public static final FlexibleDate DEFAULT_一次判定結果送付年月日 = new FlexibleDate("20150402");
    public static final RString DEFAULT_チャート = new RString("1");
    public static final RString DEFAULT_状態像 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5116IchijiHanteiKekkaJohoEntityGenerator() {
    }

    public static DbT5116IchijiHanteiKekkaJohoEntity createDbT5116IchijiHanteiKekkaJohoEntity() {
        DbT5116IchijiHanteiKekkaJohoEntity entity = new DbT5116IchijiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setKariIchijiHanteiKubun(DEFAULT_仮一次判定区分);
        entity.setIchijiHanteiYMD(DEFAULT_要介護認定一次判定年月日);
        entity.setIchijiHanteiKekkaCode(DEFAULT_要介護認定一次判定結果コード);
        entity.setIchijiHanteiKekkaNinchishoKasanCode(DEFAULT_要介護認定一次判定結果コード_認知症加算_);
        entity.setKijunJikan(DEFAULT_要介護認定等基準時間);
        entity.setKijunJikanShokuji(DEFAULT_要介護認定等基準時間_食事_);
        entity.setKijunJikanHaisetsu(DEFAULT_要介護認定等基準時間_排泄_);
        entity.setKijunJikanIdo(DEFAULT_要介護認定等基準時間_移動_);
        entity.setKijunJikanSeiketsuHoji(DEFAULT_要介護認定等基準時間_清潔保持_);
        entity.setKijunJikanKansetsuCare(DEFAULT_要介護認定等基準時間_間接ケア_);
        entity.setKijunJikanBPSDKanren(DEFAULT_要介護認定等基準時間_BPSD関連_);
        entity.setKijunJikanKinoKunren(DEFAULT_要介護認定等基準時間_機能訓練_);
        entity.setKijunJikanIryoKanren(DEFAULT_要介護認定等基準時間_医療関連_);
        entity.setKijunJikanNinchishoKasan(DEFAULT_要介護認定等基準時間_認知症加算_);
        entity.setChukanHyokaKomoku1gun(DEFAULT_中間評価項目得点第1群);
        entity.setChukanHyokaKomoku2gun(DEFAULT_中間評価項目得点第2群);
        entity.setChukanHyokaKomoku3gun(DEFAULT_中間評価項目得点第3群);
        entity.setChukanHyokaKomoku4gun(DEFAULT_中間評価項目得点第4群);
        entity.setChukanHyokaKomoku5gun(DEFAULT_中間評価項目得点第5群);
        entity.setChukanHyokaKomoku6gun(DEFAULT_中間評価項目得点第6群);
        entity.setChukanHyokaKomoku7gun(DEFAULT_中間評価項目得点第7群);
        entity.setIchijiHnateiKeikokuCode(DEFAULT_要介護認定一次判定警告コード);
        entity.setJotaiAnteiseiCode(DEFAULT_要介護認定状態の安定性コード);
        entity.setNinchishoJiritsudoIIijoNoGaizensei(DEFAULT_認知症自立度Ⅱ以上の蓋然性);
        entity.setSuiteiKyufuKubunCode(DEFAULT_認知機能及び状態安定性から推定される給付区分コード);
        entity.setNinchishoKoreishaShihyoCode(DEFAULT_運動能力の低下していない認知症高齢者の指標コード);
        entity.setJiritsudoKumiawase1(DEFAULT_日常生活自立度の組み合わせ_自立_);
        entity.setJiritsudoKumiawase2(DEFAULT_日常生活自立度の組み合わせ_要支援_);
        entity.setJiritsudoKumiawase3(DEFAULT_日常生活自立度の組み合わせ_要介護１_);
        entity.setJiritsudoKumiawase4(DEFAULT_日常生活自立度の組み合わせ_要介護２_);
        entity.setJiritsudoKumiawase5(DEFAULT_日常生活自立度の組み合わせ_要介護３_);
        entity.setJiritsudoKumiawase6(DEFAULT_日常生活自立度の組み合わせ_要介護４_);
        entity.setJiritsudoKumiawase7(DEFAULT_日常生活自立度の組み合わせ_要介護５_);
        entity.setGaizenseiHyokaCode(DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価コード);
        entity.setGaizenseiHyokaPercent(DEFAULT_認知症高齢者の日常生活自立度の蓋然性評価);
        entity.setIchijiHanteiSofuKubun(DEFAULT_一次判定結果送付区分);
        entity.setIchijiHanteiKekkaSofuYMD(DEFAULT_一次判定結果送付年月日);
        entity.setChert(DEFAULT_チャート);
        entity.setJotaizo(DEFAULT_状態像);
        return entity;
    }
}
