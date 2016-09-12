/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 委員用介護認定審査対象者一覧表情報のProcessParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinShinsakaiIinJohoProcessParameter implements IBatchProcessParameter {

    private int gogitaiNo;
    private int bangoStart;
    private int bangoEnd;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private RString shuturyokuSutairu;
    private RString printHou;
    private Decimal chohyoIinHusu;
    private RString shinsakaiKaishiYoteiTime;
    private RString sakuseiJoken;
    private final RString 作成条件_範囲指定 = new RString("範囲指定");
    private final RString 作成条件_追加分 = new RString("追加分");

    /**
     * コンストラクタです。
     *
     * @param gogitaiNo 合議体番号
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuJun 出力順
     * @param shuturyokuSutairu 出力スタイル
     * @param printHou 印刷方法
     * @param shinsakaiKaishiYoteiTime 介護認定審査会開始予定時刻
     * @param sakuseiJoken 作成条件
     * @param bangoStart 開始資料番号
     * @param bangoEnd 終了資料番号
     */
    public IinShinsakaiIinJohoProcessParameter(
            int gogitaiNo,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaisaiNo,
            RString shuturyokuJun,
            RString shuturyokuSutairu,
            RString printHou,
            RString shinsakaiKaishiYoteiTime,
            RString sakuseiJoken,
            int bangoStart,
            int bangoEnd) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.gogitaiNo = gogitaiNo;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shuturyokuSutairu = shuturyokuSutairu;
        this.printHou = printHou;
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
        this.sakuseiJoken = sakuseiJoken;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
    }

    /**
     * 委員用特記事項と一次判定結果票情報のMyBatisParameterに転換します。
     *
     * @return IinTokkiJikouItiziHanteiMyBatisParameter
     */
    public IinShinsakaiIinJohoMyBatisParameter toIinShinsakaiIinJohoMyBatisParameter() {
        boolean isShuturyokuJunEmpty = false;
        boolean isSakuseiJokenHani = false;
        boolean isSakuseiJokenTuika = false;
        if (作成条件_範囲指定.equals(sakuseiJoken)) {
            isSakuseiJokenHani = true;
        }
        if (作成条件_追加分.equals(sakuseiJoken)) {
            isSakuseiJokenTuika = true;
        }
        if (RString.isNullOrEmpty(shuturyokuJun)) {
            isShuturyokuJunEmpty = true;
        }
        return new IinShinsakaiIinJohoMyBatisParameter(gogitaiNo, bangoStart, bangoEnd,
                shinsakaiKaisaiYoteiYMD, shinsakaiKaisaiNo, shuturyokuJun, isSakuseiJokenHani, isSakuseiJokenTuika, isShuturyokuJunEmpty);
    }

    /**
     * 事務局用介護認定審査対象者一覧表情報のMyBatisParameterに転換します。
     *
     * @return JimuShinsakaiIinJohoMyBatisParameter
     */
    public JimuShinsakaiIinJohoMyBatisParameter toJimuShinsakaiIinJohoMyBatisParameter() {
        boolean isShuturyokuJun = false;
        boolean isSakuseiJokenHani = false;
        boolean isSakuseiJokenTuika = false;
        if (作成条件_範囲指定.equals(sakuseiJoken)) {
            isSakuseiJokenHani = true;
        }
        if (作成条件_追加分.equals(sakuseiJoken)) {
            isSakuseiJokenTuika = true;
        }
        if (RString.isNullOrEmpty(shuturyokuJun)) {
            isShuturyokuJun = true;
        }
        return new JimuShinsakaiIinJohoMyBatisParameter(bangoStart, bangoEnd, shuturyokuJun,
                isShuturyokuJun, isSakuseiJokenHani, isSakuseiJokenTuika, shinsakaiKaisaiNo, gogitaiNo, shinsakaiKaisaiYoteiYMD);
    }
}
