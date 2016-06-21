/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 委員用特記事項と一次判定結果票情報のProcessParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinTokkiJikouItiziHanteiProcessParameter implements IBatchProcessParameter {

    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private RString sakuseiJoken;
    private Decimal bangoStart;
    private Decimal bangoEnd;
    private final RString 作成条件_範囲指定 = new RString("範囲指定");
    private final RString 作成条件_追加分 = new RString("追加分");
    private RString shuturyokuSutairu;
    private RString printHou;
    private Decimal chohyoIinHusu;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString gogitaiName;
    private RString gogitaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuJun 出力順
     * @param sakuseiJoken 作成条件
     * @param bangoStart 開始資料番号
     * @param bangoEnd 終了資料番号
     * @param shuturyokuSutairu 出力スタイル
     * @param printHou 印刷方法
     * @param chohyoIinHusu 審査会委員用部数
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     * @param shinsakaiKaishiYoteiTime 介護認定審査会開始予定時刻
     * @param gogitaiName 合議体名称
     * @param gogitaiNo 合議体番号
     */
    public IinTokkiJikouItiziHanteiProcessParameter(
            RString shinsakaiKaisaiNo,
            RString shuturyokuJun,
            RString sakuseiJoken,
            Decimal bangoStart,
            Decimal bangoEnd,
            RString shuturyokuSutairu,
            RString printHou,
            Decimal chohyoIinHusu,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaishiYoteiTime,
            RString gogitaiName,
            RString gogitaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.sakuseiJoken = sakuseiJoken;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.shuturyokuSutairu = shuturyokuSutairu;
        this.printHou = printHou;
        this.chohyoIinHusu = chohyoIinHusu;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
        this.gogitaiName = gogitaiName;
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * 委員用特記事項と一次判定結果票情報のMyBatisParameterに転換します。
     *
     * @return IinTokkiJikouItiziHanteiMyBatisParameter
     */
    public IinTokkiJikouItiziHanteiMyBatisParameter toIinTokkiJikouItiziHanteiMyBatisParameter() {
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
        return new IinTokkiJikouItiziHanteiMyBatisParameter(shinsakaiKaisaiNo, shuturyokuJun, bangoStart, bangoEnd,
                isSakuseiJokenHani, isSakuseiJokenTuika, isShuturyokuJun);
    }
}
