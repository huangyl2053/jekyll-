/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用一次判定結果情報のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinItiziHanteiMyBatisParameter implements IMyBatisParameter {

    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private int bangoStart;
    private int bangoEnd;
    private ShinseishoKanriNo shinseishoKanri;
    private int ninteichosaRirekiNo;
    private RString genponKubun;
    private boolean isSakuseiJokenHani;
    private boolean isIsShuturyokuJun;
    private boolean isSakuseiJokenTuika;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuJun 出力順
     * @param bangoStart 開始資料番号
     * @param bangoEnd 終了資料番号
     * @param isSakuseiJokenHani 作成条件_範囲指定ファグ
     * @param isSakuseiJokenTuika 作成条件_追加分ファグ
     * @param isIsShuturyokuJun 出力順ファグ
     */
    public IinItiziHanteiMyBatisParameter(
            RString shinsakaiKaisaiNo,
            RString shuturyokuJun,
            int bangoStart,
            int bangoEnd,
            boolean isSakuseiJokenHani,
            boolean isSakuseiJokenTuika,
            boolean isIsShuturyokuJun) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.isSakuseiJokenHani = isSakuseiJokenHani;
        this.isSakuseiJokenTuika = isSakuseiJokenTuika;
        this.isIsShuturyokuJun = isIsShuturyokuJun;
    }
}
