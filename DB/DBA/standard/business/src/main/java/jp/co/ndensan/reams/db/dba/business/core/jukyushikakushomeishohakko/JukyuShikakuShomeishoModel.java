package jp.co.ndensan.reams.db.dba.business.core.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dba.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 *
 */
public class JukyuShikakuShomeishoModel {

    private JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoEntity;

    /**
     * コンストラクタです。
     */
    public JukyuShikakuShomeishoModel() {
    }

    /**
     * コンストラクタです。
     *
     * @param jukyuShikakuShomeishoHakko JukyuShikakuShomeishoHakkoRelateEntity
     */
    public JukyuShikakuShomeishoModel(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakko) {
        this.jukyuShikakuShomeishoHakkoEntity = jukyuShikakuShomeishoHakko;
    }

    /**
     * 交付日を取得します。
     *
     * @return 交付日
     */
    public RString get交付日() {
        if (jukyuShikakuShomeishoHakkoEntity != null) {
            return FlexibleDate.getNowDate().getYearMonth().wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 異動予定日を取得します。
     *
     * @return 異動予定日
     */
    public RString get異動予定日() {
        if (jukyuShikakuShomeishoHakkoEntity != null && jukyuShikakuShomeishoHakkoEntity.getIdoYMD() != null
                && !jukyuShikakuShomeishoHakkoEntity.getIdoYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuShomeishoHakkoEntity.getIdoYMD()).wareki().toDateString();
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
        if (jukyuShikakuShomeishoHakkoEntity != null && !jukyuShikakuShomeishoHakkoEntity.getYokaigoJotaiKubunCode().isEmpty()) {
            return YokaigoJotaiKubun09.toValue(jukyuShikakuShomeishoHakkoEntity.getYokaigoJotaiKubunCode()).getName();
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
        if (jukyuShikakuShomeishoHakkoEntity != null && !jukyuShikakuShomeishoHakkoEntity.getNinteiYukoKikanKaishiYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuShomeishoHakkoEntity.getNinteiYukoKikanKaishiYMD()).wareki().toDateString();
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
        if (jukyuShikakuShomeishoHakkoEntity != null && !jukyuShikakuShomeishoHakkoEntity.getJukyuShinseiYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuShomeishoHakkoEntity.getJukyuShinseiYMD()).wareki().toDateString();
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
        if (jukyuShikakuShomeishoHakkoEntity != null && !jukyuShikakuShomeishoHakkoEntity.getNinteiYukoKikanShuryoYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuShomeishoHakkoEntity.getNinteiYukoKikanShuryoYMD()).wareki().toDateString();
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
        if (jukyuShikakuShomeishoHakkoEntity != null && !jukyuShikakuShomeishoHakkoEntity.getShinsakaiIken().isEmpty()) {
            return jukyuShikakuShomeishoHakkoEntity.getShinsakaiIken();
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
        if (jukyuShikakuShomeishoHakkoEntity != null && !jukyuShikakuShomeishoHakkoEntity.getBiko().isEmpty()) {
            return jukyuShikakuShomeishoHakkoEntity.getBiko();
        } else {
            return RString.EMPTY;
        }
    }

}
