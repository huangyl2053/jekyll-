/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijipanteisyori;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijipanteisyori.IChiJiPanTeiSyoRiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
public class IChiJiPanTeiSyoRiBusiness implements Serializable {

    private final IChiJiPanTeiSyoRiRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * 対象者一覧に使用します。
     *
     * @param entity IChiJiPanTeiSyoRiRelateEntity
     */
    public IChiJiPanTeiSyoRiBusiness(IChiJiPanTeiSyoRiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分_申請時コードを取得します。
     *
     * @return 認定申請区分_申請時コード
     */
    public Code get認定申請区分_申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 要介護認定一次判定年月日を取得します。
     *
     * @return 要介護認定一次判定年月日
     */
    public FlexibleDate get要介護認定一次判定年月日() {
        return entity.getIchijiHanteiYMD();
    }

    /**
     * 要介護認定一次判定結果コードを取得します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 要介護認定一次判定警告コードを取得します。
     *
     * @return 要介護認定一次判定警告コード
     */
    public RString get要介護認定一次判定警告コード() {
        return entity.getIchijiHnateiKeikokuCode();
    }

    /**
     * 要介護認定一次判定結果コード_認知症加算を取得します。
     *
     * @return 要介護認定一次判定結果コード_認知症加算
     */
    public Code get要介護認定一次判定結果コード_認知症加算() {
        return entity.getIchijiHanteiKekkaNinchishoKasanCode();
    }

    /**
     * 要介護認定等基準時間を取得します。
     *
     * @return 要介護認定等基準時間
     */
    public int get要介護認定等基準時間() {
        return entity.getKijunJikan();
    }

    /**
     * 要介護認定等基準時間_食事を取得します。
     *
     * @return 要介護認定等基準時間_食事
     */
    public int get要介護認定等基準時間_食事() {
        return entity.getKijunJikanShokuji();
    }

    /**
     * 要介護認定等基準時間_排泄を取得します。
     *
     * @return 要介護認定等基準時間_排泄
     */
    public int get要介護認定等基準時間_排泄() {
        return entity.getKijunJikanHaisetsu();
    }

    /**
     * 要介護認定等基準時間_移動を取得します。
     *
     * @return 要介護認定等基準時間_移動
     */
    public int get要介護認定等基準時間_移動() {
        return entity.getKijunJikanIdo();
    }

    /**
     * 要介護認定等基準時間_清潔保持を取得します。
     *
     * @return 要介護認定等基準時間_清潔保持
     */
    public int get要介護認定等基準時間_清潔保持() {
        return entity.getKijunJikanSeiketsuHoji();
    }

    /**
     * 要介護認定等基準時間_間接ケアを取得します。
     *
     * @return 要介護認定等基準時間_間接ケア
     */
    public int get要介護認定等基準時間_間接ケア() {
        return entity.getKijunJikanKansetsuCare();
    }

    /**
     * 要介護認定等基準時間_BPSD関連を取得します。
     *
     * @return 要介護認定等基準時間_BPSD関連
     */
    public int get要介護認定等基準時間_BPSD関連() {
        return entity.getKijunJikanBPSDKanren();
    }

    /**
     * 要介護認定等基準時間_機能訓練を取得します。
     *
     * @return 要介護認定等基準時間_機能訓練
     */
    public int get要介護認定等基準時間_機能訓練() {
        return entity.getKijunJikanKinoKunren();
    }

    /**
     * 要介護認定等基準時間_医療関連を取得します。
     *
     * @return 要介護認定等基準時間_医療関連
     */
    public int get要介護認定等基準時間_医療関連() {
        return entity.getKijunJikanIryoKanren();
    }

    /**
     * 要介護認定等基準時間_認知症加算を取得します。
     *
     * @return 要介護認定等基準時間_認知症加算
     */
    public int get要介護認定等基準時間_認知症加算() {
        return entity.getKijunJikanNinchishoKasan();
    }

    /**
     * 中間評価項目得点第1群を取得します。
     *
     * @return 中間評価項目得点第1群
     */
    public int get中間評価項目得点第1群() {
        return entity.getChukanHyokaKomoku1gun();
    }

    /**
     * 中間評価項目得点第2群を取得します。
     *
     * @return 中間評価項目得点第2群
     */
    public int get中間評価項目得点第2群() {
        return entity.getChukanHyokaKomoku2gun();
    }

    /**
     * 中間評価項目得点第3群を取得します。
     *
     * @return 中間評価項目得点第3群
     */
    public int get中間評価項目得点第3群() {
        return entity.getChukanHyokaKomoku3gun();
    }

    /**
     * 中間評価項目得点第4群を取得します。
     *
     * @return 中間評価項目得点第4群
     */
    public int get中間評価項目得点第4群() {
        return entity.getChukanHyokaKomoku4gun();
    }

    /**
     * 中間評価項目得点第5群を取得します。
     *
     * @return 中間評価項目得点第5群
     */
    public int get中間評価項目得点第5群() {
        return entity.getChukanHyokaKomoku5gun();
    }

    /**
     * 要介護認定状態の安定性コードを取得します。
     *
     * @return 要介護認定状態の安定性コード
     */
    public Code get要介護認定状態の安定性コード() {
        return entity.getJotaiAnteiseiCode();
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性を取得します。
     *
     * @return 認知症自立度Ⅱ以上の蓋然性
     */
    public Decimal get認知症自立度Ⅱ以上の蓋然性() {
        return entity.getNinchishoJiritsudoIIijoNoGaizensei();
    }

    /**
     * 推定される給付区分コードを取得します。
     *
     * @return 推定される給付区分コード
     */
    public Code get推定される給付区分コード() {
        return entity.getSuiteiKyufuKubunCode();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 主治医意見書受領年月日を取得します。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate get主治医意見書受領年月日() {
        return entity.getIkenshoJuryoYMD();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }
}
