/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinIkenshoDataSakuseiMyBatisParameter implements IMyBatisParameter {

    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private int bangoStart;
    private int bangoEnd;
    private ShinseishoKanriNo shinseishoKanri;
    private int ninteichosaRirekiNo;
    private RString genponMaskKubun;
    private boolean isShuturyokuJunEmpty;
    private boolean isSakuseiJokenHani;
    private boolean isSakuseiJokenTuika;
    private boolean isOrderKakuteiFlg;
    private List<RString> shoriJotaiKubunList;
    private List<ShinseishoKanriNo> shinseishoKanriNoList;
    private List<Integer> ninteichosaRirekiNoList;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuJun 出力順
     * @param bangoStart 開始資料番号
     * @param bangoEnd 終了資料番号
     * @param isSakuseiJokenHani 作成条件_範囲指定ファグ
     * @param isSakuseiJokenTuika 作成条件_追加分ファグ
     * @param isShuturyokuJunEmpty 出力順ファグ
     */
    public IinIkenshoDataSakuseiMyBatisParameter(
            RString shinsakaiKaisaiNo,
            RString shuturyokuJun,
            int bangoStart,
            int bangoEnd,
            boolean isSakuseiJokenHani,
            boolean isSakuseiJokenTuika,
            boolean isShuturyokuJunEmpty) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.isSakuseiJokenHani = isSakuseiJokenHani;
        this.isSakuseiJokenTuika = isSakuseiJokenTuika;
        this.isShuturyokuJunEmpty = isShuturyokuJunEmpty;
    }
}
