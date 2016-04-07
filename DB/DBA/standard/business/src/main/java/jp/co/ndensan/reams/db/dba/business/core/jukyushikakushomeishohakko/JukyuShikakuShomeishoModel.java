package jp.co.ndensan.reams.db.dba.business.core.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dba.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証・資格者証発行を表すクラスです。
 *
 */
public class JukyuShikakuShomeishoModel {

    private final JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuEntity;

    /**
     * コンストラクタです。
     *
     * @param jukyuShikakuShomeishoHakko 介護認定審査会開催場所情報テーブルのエンティティクラスです
     */
    public JukyuShikakuShomeishoModel(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakko) {
        this.jukyuShikakuEntity = jukyuShikakuShomeishoHakko;
    }

    /**
     * 交付日を取得します。
     *
     * @return 交付日
     */
    public RString get交付日() {
        return FlexibleDate.getNowDate().getYearMonth().wareki().toDateString();
    }

    /**
     * 異動予定日を取得します。
     *
     * @return 異動予定日
     */
    public RString get異動予定日() {
        if (jukyuShikakuEntity.getIdoYMD() != null
                && !jukyuShikakuEntity.getIdoYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity.getIdoYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 要介護状態区分を取得します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        if (jukyuShikakuEntity.getYokaigoJotaiKubunCode() != null 
                && !jukyuShikakuEntity.getYokaigoJotaiKubunCode().isEmpty()) {
            return YokaigoJotaiKubun09.toValue(jukyuShikakuEntity.getYokaigoJotaiKubunCode()).getName();
        } else {
            return RString.EMPTY;
        }

    }

    /**
     * 有効期間開始日を取得します。
     *
     * @return 有効期間開始日
     */
    public RString get有効期間開始日() {
        if (jukyuShikakuEntity.getNinteiYukoKikanKaishiYMD() != null 
                && !jukyuShikakuEntity.getNinteiYukoKikanKaishiYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity
                    .getNinteiYukoKikanKaishiYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }

    }

    /**
     * 受給申請年月日を取得します。
     *
     * @return 受給申請年月日
     */
    public RString get受給申請年月日() {
        if (jukyuShikakuEntity.getJukyuShinseiYMD() != null 
                && !jukyuShikakuEntity.getJukyuShinseiYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity.getJukyuShinseiYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 有効期間終了日を取得します。
     *
     * @return 有効期間開始日
     */
    public RString get有効期間終了日() {
        if (jukyuShikakuEntity.getNinteiYukoKikanShuryoYMD() != null 
                && !jukyuShikakuEntity.getNinteiYukoKikanShuryoYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity
                    .getNinteiYukoKikanShuryoYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 介護認定審査会意見を取得します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        if (jukyuShikakuEntity.getShinsakaiIken() != null 
                && !jukyuShikakuEntity.getShinsakaiIken().isEmpty()) {
            return jukyuShikakuEntity.getShinsakaiIken();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 介護認定審査会意見を取得します。
     *
     * @return 介護認定審査会意見
     */
    public RString get備考() {
        if (jukyuShikakuEntity.getBiko() != null
                && !jukyuShikakuEntity.getBiko().isEmpty()) {
            return jukyuShikakuEntity.getBiko();
        } else {
            return RString.EMPTY;
        }
    }
}
