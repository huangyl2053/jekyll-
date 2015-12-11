package jp.co.ndensan.reams.db.dba.business.core.roreifukushinenkinjoho;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author soft863
 */
public class BRoreiFukushiNenkinJoho {

    private final DbT7006RoreiFukushiNenkinJukyushaEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 資格得喪Entity
     */
    public BRoreiFukushiNenkinJoho(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>識別コード
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return entity.getShikibetsuCode();
    }

    /**
     * 受給開始年月日のgetメソッドです。
     * <br/>
     * <br/>受給開始年月日
     *
     * @return 受給開始年月日
     */
    public FlexibleDate getJukyuKaishiYMD() {
        return entity.getJukyuKaishiYMD();
    }

    /**
     * 受給終了年月日のgetメソッドです。
     * <br/>
     * <br/>受給終了年月日
     *
     * @return 受給終了年月日
     */
    public FlexibleDate getJukyuShuryoYMD() {
        return entity.getJukyuShuryoYMD();
    }

    /**
     * 被保険者番号のgetメソッドです。
     * <br/>
     * <br/>被保険者番号
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return entity.getHihokenshaNo();
    }

}
