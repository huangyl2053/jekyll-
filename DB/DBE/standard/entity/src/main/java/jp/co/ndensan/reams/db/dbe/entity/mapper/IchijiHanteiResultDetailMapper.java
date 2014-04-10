/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultKomoku;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.business.JotaiAnteiseiKubun;
import jp.co.ndensan.reams.db.dbe.business.NichijoSeikatsuJiritsudoKumiawase;
import jp.co.ndensan.reams.db.dbe.business.NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.business.NoryokuMiteikaNinchishoKoreishaShihyoKomoku;
import jp.co.ndensan.reams.db.dbe.business.SuiteiKyuhuKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiChukanHyokaKomokuTokuten;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiKijunTime;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;

/**
 * 一次判定結果の詳細情報をマッピングするクラスです。
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiResultDetailMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private IchijiHanteiResultDetailMapper() {
    }

    /**
     * 引数から一次判定結果Entityと一次判定警告Listを受け取り、その情報をマッピングして一次判定クラスを作成します。<br/>
     * 引数のいずれかにnullが渡された場合はnullが返ります。
     *
     * @param entity 一次判定結果Entity
     * @param 一次判定警告List 一次判定警告List
     * @return 一次判定結果
     */
    public static IchijiHanteiResultDetail to一次判定結果(DbT5016IchijiHanteiKekkaJohoEntity entity, IchijiHanteiKeikokuList 一次判定警告List) {
        if (entity == null || 一次判定警告List == null) {
            return null;
        }
        return new IchijiHanteiResultDetail(entity.getShinseishoKanriNo(),
                KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode()),
                KariIchijiHanteiKubun.toValue(entity.getKariIchijiHanteiKubun()),
                entity.getIchijiHanteiYMD(),
                create一次判定結果(entity),
                create認知症加算一次判定結果(entity),
                create要介護認定等基準時間(entity),
                create中間項目得点群(entity),
                一次判定警告List,
                create介護認定状態安定性(entity),
                entity.getNinchishoJiritsudoIIijoNoGaizensei(),
                create推定給付区分(entity),
                create能力未低下認知症高齢者指標(entity),
                create日常生活自立度組み合わせ(entity),
                create認知症高齢者自立度蓋然性評価(entity),
                entity.getGaizenseiHyokaPercent(),
                entity.getIchijiHanteiSofuKubun(),
                entity.getIchijiHanteiKekkaSofuYMD());
    }

    private static IchijiHanteiResultKomoku create一次判定結果(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new IchijiHanteiResultKomoku(entity.getIchijiHanteiKekkaCode(),
                entity.getIchijiHanteiKekkaCodeMeisho(), entity.getIchijiHanteiKekkaCodeRyakusho());
    }

    private static IchijiHanteiResultKomoku create認知症加算一次判定結果(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new IchijiHanteiResultKomoku(entity.getIchijiHanteiKekkaNinchishoKasanCode(),
                entity.getIchijiHanteiKekkaNinchishoKasanCodeMeisho(), entity.getIchijiHanteiKekkaNinchishoKasanCodeRyakusho());
    }

    private static YokaigoNinteiKijunTime create要介護認定等基準時間(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new YokaigoNinteiKijunTime(entity.getKijunJikan(), entity.getKijunJikanShokuji(),
                entity.getKijunJikanHaisetsu(), entity.getKijunJikanIdo(), entity.getKijunJikanSeiketsuHoji(),
                entity.getKijunJikanKansetsuCare(), entity.getKijunJikanBPSDKanren(), entity.getKijunJikanKinoKunren(),
                entity.getKijunJikanIryoKanren(), entity.getKijunJikanNinchishoKasan());
    }

    private static YokaigoNinteiChukanHyokaKomokuTokuten create中間項目得点群(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new YokaigoNinteiChukanHyokaKomokuTokuten(entity.getChukanHyokaKomoku1gun(),
                entity.getChukanHyokaKomoku2gun(), entity.getChukanHyokaKomoku3gun(), entity.getChukanHyokaKomoku4gun(),
                entity.getChukanHyokaKomoku5gun(), entity.getChukanHyokaKomoku6gun(), entity.getChukanHyokaKomoku7gun());
    }

    private static JotaiAnteiseiKubun create介護認定状態安定性(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new JotaiAnteiseiKubun(entity.getJotaiAnteiseiCode(),
                entity.getJotaiAnteiseiCodeMeisho(), entity.getJotaiAnteiseiCodeRyakusho());
    }

    private static SuiteiKyuhuKubun create推定給付区分(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new SuiteiKyuhuKubun(entity.getSuiteiKyufuKubunCode(),
                entity.getSuiteiKyufuKubunCodeMeisho(), entity.getSuiteiKyufuKubunCodeRyakusho());
    }

    private static NoryokuMiteikaNinchishoKoreishaShihyoKomoku create能力未低下認知症高齢者指標(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(entity.getNinchishoKoreishaShihyoCode(),
                entity.getNinchishoKoreishaShihyoCodeMeisho(), entity.getNinchishoKoreishaShihyoCodeRyakusho());
    }

    private static NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku create認知症高齢者自立度蓋然性評価(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(entity.getGaizenseiHyokaCode(),
                entity.getGaizenseiHyokaCodeMeisho(), entity.getGaizenseiHyokaCodeRyakusho());
    }

    private static NichijoSeikatsuJiritsudoKumiawase create日常生活自立度組み合わせ(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new NichijoSeikatsuJiritsudoKumiawase(entity.getJiiritsudoKumiawase1(), entity.getJiiritsudoKumiawase2(),
                entity.getJiiritsudoKumiawase3(), entity.getJiiritsudoKumiawase4(), entity.getJiiritsudoKumiawase5(),
                entity.getJiiritsudoKumiawase6(), entity.getJiiritsudoKumiawase7());
    }

    /**
     * 一次判定結果を受け取り、その情報をマッピングして一次判定結果Entityを生成します。<br/>
     * 引数にnullが渡されたときはnullが返ります。
     *
     * @param 一次判定結果 一次判定結果
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity to一次判定結果Entity(IchijiHanteiResultDetail 一次判定結果) {
        if (一次判定結果 == null) {
            return null;
        }
        DbT5016IchijiHanteiKekkaJohoEntity entity = new DbT5016IchijiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(一次判定結果.get申請書管理番号());
        entity.setKoroshoIfShikibetsuCode(一次判定結果.get厚労省IF区分().getCode());
        entity.setKariIchijiHanteiKubun(一次判定結果.get仮一次判定区分().is仮判定());
        entity.setIchijiHanteiYMD(一次判定結果.get一次判定年月日());
        entity.setIchijiHanteiKekkaCode(一次判定結果.get一次判定結果().getCode());
        entity.setIchijiHanteiKekkaNinchishoKasanCode(一次判定結果.get認知症加算一次判定結果().getCode());
        entity.setKijunJikan(一次判定結果.get要介護認定等基準時間().get基準時間());
        entity.setKijunJikanShokuji(一次判定結果.get要介護認定等基準時間().get食事基準時間());
        entity.setKijunJikanHaisetsu(一次判定結果.get要介護認定等基準時間().get排泄基準時間());
        entity.setKijunJikanIdo(一次判定結果.get要介護認定等基準時間().get移動基準時間());
        entity.setKijunJikanSeiketsuHoji(一次判定結果.get要介護認定等基準時間().get清潔保持基準時間());
        entity.setKijunJikanKansetsuCare(一次判定結果.get要介護認定等基準時間().get間接ケア基準時間());
        entity.setKijunJikanBPSDKanren(一次判定結果.get要介護認定等基準時間().getBPSD関連基準時間());
        entity.setKijunJikanKinoKunren(一次判定結果.get要介護認定等基準時間().get機能訓練基準時間());
        entity.setKijunJikanIryoKanren(一次判定結果.get要介護認定等基準時間().get医療関連基準時間());
        entity.setKijunJikanNinchishoKasan(一次判定結果.get要介護認定等基準時間().get認知症加算基準時間());
        entity.setChukanHyokaKomoku1gun(一次判定結果.get中間評価項目得点().get第1群());
        entity.setChukanHyokaKomoku2gun(一次判定結果.get中間評価項目得点().get第2群());
        entity.setChukanHyokaKomoku3gun(一次判定結果.get中間評価項目得点().get第3群());
        entity.setChukanHyokaKomoku4gun(一次判定結果.get中間評価項目得点().get第4群());
        entity.setChukanHyokaKomoku5gun(一次判定結果.get中間評価項目得点().get第5群());
        entity.setChukanHyokaKomoku6gun(一次判定結果.get中間評価項目得点().get第6群());
        entity.setChukanHyokaKomoku7gun(一次判定結果.get中間評価項目得点().get第7群());
        entity.setIchijiHnateiKeikokuCode(一次判定結果.get一次判定警告List().get警告配列コード().toRString());
        entity.setJotaiAnteiseiCode(一次判定結果.get認定状態安定性().getCode());
        entity.setNinchishoJiritsudoIIijoNoGaizensei(一次判定結果.get認知症自立度2以上蓋然性());
        entity.setSuiteiKyufuKubunCode(一次判定結果.get推定給付区分().getCode());
        entity.setNinchishoKoreishaShihyoCode(一次判定結果.get運動能力未低下認知症高齢者指標().getCode());
        entity.setJiiritsudoKumiawase1(一次判定結果.get日常生活自立度組み合わせ().get自立());
        entity.setJiiritsudoKumiawase2(一次判定結果.get日常生活自立度組み合わせ().get要支援());
        entity.setJiiritsudoKumiawase3(一次判定結果.get日常生活自立度組み合わせ().get要介護1());
        entity.setJiiritsudoKumiawase4(一次判定結果.get日常生活自立度組み合わせ().get要介護2());
        entity.setJiiritsudoKumiawase5(一次判定結果.get日常生活自立度組み合わせ().get要介護3());
        entity.setJiiritsudoKumiawase6(一次判定結果.get日常生活自立度組み合わせ().get要介護4());
        entity.setJiiritsudoKumiawase7(一次判定結果.get日常生活自立度組み合わせ().get要介護5());
        entity.setGaizenseiHyokaCode(一次判定結果.get認知症高齢者日常生活自立度蓋然性評価().getCode());
        entity.setGaizenseiHyokaPercent(一次判定結果.get認知症高齢者日常生活自立度蓋然性評価率());
        entity.setIchijiHanteiSofuKubun(一次判定結果.get一次判定結果送付区分());
        entity.setIchijiHanteiKekkaSofuYMD(一次判定結果.get一次判定結果送付年月日());
        return entity;
    }
}
