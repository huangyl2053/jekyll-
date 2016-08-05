/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiTsutishoIkkatsuHakkoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 要介護認定通知書一括発行情報です。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public class YokaigoNinteiTsutishoIkkatsuHakkoJoho {

    private final YokaigoNinteiTsutishoIkkatsuHakkoEntity entity;

    /**
     * コンストラクタです。<br/>
     * 要介護認定通知書一括発行情報に使用します。
     *
     * @param entity YokaigoNinteiTsutishoIkkatsuHakkoEntity
     */
    public YokaigoNinteiTsutishoIkkatsuHakkoJoho(YokaigoNinteiTsutishoIkkatsuHakkoEntity entity) {
        this.entity = entity;
    }

    /**
     * 対象開始年月日を返します。
     *
     * @return 対象開始年月日 FlexibleDate
     */
    public FlexibleDate get対象開始年月日() {
        return null == entity ? FlexibleDate.EMPTY : entity.get対象開始年月日();
    }

    /**
     * 対象終了年月日を返します。
     *
     * @return 対象終了年月日 FlexibleDate
     */
    public FlexibleDate get対象終了年月日() {
        return null == entity ? FlexibleDate.EMPTY : entity.get対象終了年月日();
    }

    /**
     * 対象開始日時を返します。
     *
     * @return 対象開始日時 RTime
     */
    public RTime get対象開始日時() {
        return null == entity ? null : new RTime(entity.get対象開始日時().toDateString());
    }

    /**
     * 対象終了日時を返します。
     *
     * @return 対象終了日時 RTime
     */
    public RTime get対象終了日時() {
        return null == entity ? null : new RTime(entity.get対象終了日時().toDateString());
    }

    /**
     * 年度を返します。
     *
     * @return 年度 FlexibleYear
     */
    public FlexibleYear get年度() {
        return null == entity ? FlexibleYear.EMPTY : entity.get年度();
    }

    /**
     * 年度内連番を返します。
     *
     * @return 年度内連番 RString
     */
    public RString get年度内連番() {
        return null == entity ? null : entity.get年度内連番();
    }
}
