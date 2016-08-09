/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料一括作成（事務局）のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JimuShinsakaiIinJohoMyBatisParameter implements IMyBatisParameter {

    private int bangoStart;
    private int bangoEnd;
    private RString shuturyokuJun;
    private boolean isIsShuturyokuJun;
    private boolean isSakuseiJokenHani;
    private boolean isSakuseiJokenTuika;
    private boolean isOrderKakuteiFlg;
    private RString shoriJotaiKubun0;
    private RString shoriJotaiKubun3;
    private RString shinsakaiKaisaiNo;
    private boolean isHaishiFlag_False;
    private boolean isHaishiFlag_True;
    private FlexibleDate sisutemuYMD;
    private int gogitaiNo;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private ShinseishoKanriNo shinseishoKanriNo;
    private int ninteichosaRirekiNo;
    private int ikenshoIraiRirekiNo;
    private ShinseishoKanriNo shinseishoKanriNoZ;
    private RString genponMaskKubun;
    private List<ShinseishoKanriNo> shinseishoKanriNoList;
    private List<Integer> ninteichosaRirekiNoList;

    /**
     * コンストラクタです。
     *
     * @param bangoStart 開始資料番号
     * @param bangoEnd 終了資料番号
     * @param shuturyokuJun 出力順
     * @param isIsShuturyokuJun 出力順ファグ
     * @param isSakuseiJokenHani 作成条件_範囲指定ファグ
     * @param isSakuseiJokenTuika 作成条件_追加分ファグ
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param gogitaiNo 合議体番号
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     */
    public JimuShinsakaiIinJohoMyBatisParameter(
            int bangoStart,
            int bangoEnd,
            RString shuturyokuJun,
            boolean isIsShuturyokuJun,
            boolean isSakuseiJokenHani,
            boolean isSakuseiJokenTuika,
            RString shinsakaiKaisaiNo,
            int gogitaiNo,
            FlexibleDate shinsakaiKaisaiYoteiYMD) {
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.shuturyokuJun = shuturyokuJun;
        this.isIsShuturyokuJun = isIsShuturyokuJun;
        this.isSakuseiJokenHani = isSakuseiJokenHani;
        this.isSakuseiJokenTuika = isSakuseiJokenTuika;
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.gogitaiNo = gogitaiNo;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
    }
}
