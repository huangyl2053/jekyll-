/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinTokkiJikouMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請者に関する基本情報のProcessParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinTokkiJikouProcessParameter implements IBatchProcessParameter {

    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private RString sakuseiJoken;
    private RString bangoStart;
    private RString bangoEnd;
    private final RString 作成条件_範囲指定 = new RString("範囲指定");
    private final RString 作成条件_追加分 = new RString("追加分");

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuJun 出力順
     * @param sakuseiJoken 作成条件
     * @param bangoStart 開始資料番号
     * @param bangoEnd 終了資料番号
     */
    public IinTokkiJikouProcessParameter(
            RString shinsakaiKaisaiNo,
            RString shuturyokuJun,
            RString sakuseiJoken,
            RString bangoStart,
            RString bangoEnd) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.sakuseiJoken = sakuseiJoken;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
    }

    /**
     * 要介護認定申請者に関する基本情報のMyBatisParameterに転換します。
     *
     * @return IinTokkiJikouMyBatisParameter
     */
    public IinTokkiJikouMyBatisParameter toIinTokkiJikouMyBatisParameter() {
        boolean isShuturyokuJun = false;
        boolean isSakuseiJokenHani = false;
        boolean isSakuseiJokenTuika = false;
        if (作成条件_範囲指定.equals(sakuseiJoken)) {
            isSakuseiJokenHani = true;
        }
        if (作成条件_追加分.equals(sakuseiJoken)) {
            isSakuseiJokenHani = true;
        }
        if (RString.isNullOrEmpty(shuturyokuJun)) {
            isShuturyokuJun = true;
        }
        return new IinTokkiJikouMyBatisParameter(shinsakaiKaisaiNo, shuturyokuJun, bangoStart, bangoEnd,
                isSakuseiJokenHani, isSakuseiJokenTuika, isShuturyokuJun);
    }
}
