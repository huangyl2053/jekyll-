/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用介護認定審査対象者一覧表のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinShinsakaiIinJohoMyBatisParameter implements IMyBatisParameter {

    private RString gogitaiNo;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private boolean isIsShuturyokuJun;
    private boolean isHaishiFlag_False;
    private boolean isHaishiFlag_True;
    private boolean isOrderKakuteiFlg;
    private FlexibleDate sisutemuYMD;
    private ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param gogitaiNo 合議体番号
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuJun 出力順
     * @param isIsShuturyokuJun 出力順ファグ
     */
    public IinShinsakaiIinJohoMyBatisParameter(
            RString gogitaiNo,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaisaiNo,
            RString shuturyokuJun,
            boolean isIsShuturyokuJun) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.gogitaiNo = gogitaiNo;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.isIsShuturyokuJun = isIsShuturyokuJun;
    }
}
