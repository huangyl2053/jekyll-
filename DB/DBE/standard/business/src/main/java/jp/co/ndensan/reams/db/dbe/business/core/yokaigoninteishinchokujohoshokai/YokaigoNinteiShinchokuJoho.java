package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJohoShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaSupport;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 要介護認定進捗状況照会ビジネスクラスです。
 *
 * @reamsid_L DBE-0210-010 dongyabin
 */
public class YokaigoNinteiShinchokuJoho implements Serializable {

    private final YokaigoNinteiShinchokuJohoShokaiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 申請者一覧内容検索情報RelateEntity
     */
    public YokaigoNinteiShinchokuJoho(YokaigoNinteiShinchokuJohoShokaiRelateEntity entity) {
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
    public ShinseishoKanriNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokenshaKubunCode();
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
     * 認定申請区分（申請時）コードを取得します。
     *
     * @return 認定申請区分申請時コード
     */
    public RString get認定申請区分申請時コード() {
        return entity.getNinteiShinShinseijiKubunCode();
    }

    /**
     * 認定調査特記を取得します。
     *
     * @return 認定調査特記
     */
    public RString get認定調査特記() {
        return entity.getTokki();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return entity.getAge();
    }

    /**
     * 認定調査依頼完了年月日を取得します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return entity.getNinteichosaIraiKanryoYMD();
    }

    /**
     * 認定調査完了年月日を取得します。
     *
     * @return 認定調査完了年月日
     */
    public FlexibleDate get認定調査完了年月日() {
        return entity.getNinteichosaKanryoYMD();
    }

    /**
     * 主治医意見書作成依頼完了年月日を取得します。
     *
     * @return 主治医意見書作成依頼完了年月日
     */
    public FlexibleDate get主治医意見書作成依頼完了年月日() {
        return entity.getIkenshoSakuseiIraiKanryoYMD();
    }

    /**
     * 主治医意見書登録完了年月日を取得します。
     *
     * @return 主治医意見書登録完了年月日
     */
    public FlexibleDate get主治医意見書登録完了年月日() {
        return entity.getIkenshoTorokuKanryoYMD();
    }

    /**
     * 要介護認定一次判定完了年月日を取得します。
     *
     * @return 要介護認定一次判定完了年月日
     */
    public FlexibleDate get要介護認定一次判定完了年月日() {
        return entity.getIchijiHanteiKanryoYMD();
    }

    /**
     * マスキング完了年月日を取得します。
     *
     * @return マスキング完了年月日
     */
    public FlexibleDate getマスキング完了年月日() {
        return entity.getMaskingKanryoYMD();
    }

    /**
     * 認定審査会割当完了年月日を取得します。
     *
     * @return 認定審査会割当完了年月日
     */
    public FlexibleDate get認定審査会割当完了年月日() {
        return entity.getNinteiShinsaWariateKanryoYMD();
    }

    /**
     * 認定審査会完了年月日を取得します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.getNinteiShinsakaiKanryoYMD();
    }

    /**
     * 認定調査依頼年月日を取得します。
     *
     * @return 認定調査依頼年月日
     */
    public FlexibleDate get認定調査依頼年月日() {
        return entity.getNinteichosaIraiYMD();
    }

    /**
     * 認定調査受領年月日を取得します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.getNinteichosaJuryoYMD();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 主治医意見書作成依頼年月日を取得します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.getIkenshoSakuseiIraiYMD();
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
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.getShujiiName();
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
    public RString get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode() == null ? RString.EMPTY : entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 一次判定結果の名称（要介護度）を返却します。
     *
     * @return 一次判定結果の名称
     */
    public RString get一次判定結果名称() {
        return IchijiHanteiKekkaSupport.toValueOrEmpty(get要介護認定一次判定結果コード()).get名称();
    }

    /**
     * 介護認定審査会開催予定年月日を取得します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate get介護認定審査会開催予定年月日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 介護認定審査会資料作成年月日を取得します。
     *
     * @return 介護認定審査会資料作成年月日
     */
    public FlexibleDate get介護認定審査会資料作成年月日() {
        return entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 介護認定審査会開催番号を取得します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 合議体名称を返します。
     *
     * @return 合議体名
     */
    public RString get合議体名() {
        return entity.getGogitaiMei();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public RString get二次判定要介護状態区分コード() {
        return entity.getNijiHanYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定結果の名称（要介護度）を返却します。
     *
     * @return 二次判定結果の名称
     */
    public RString get二次判定結果名称() {
        IYokaigoJotaiKubun yokaigodo = YokaigoJotaiKubunSupport.toValueOrEmpty(get二次判定要介護状態区分コード());
        return yokaigodo.getCode().equals(new RString("99")) ? RString.EMPTY : yokaigodo.getName();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

}
