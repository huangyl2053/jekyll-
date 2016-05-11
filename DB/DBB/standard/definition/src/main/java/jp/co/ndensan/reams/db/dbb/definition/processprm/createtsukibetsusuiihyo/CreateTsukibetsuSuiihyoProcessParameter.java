/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 月別推移表作成のバッチ処理クラスのパラメータです。
 *
 * @reamsid_L DBB-0760-020 zhangguopeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateTsukibetsuSuiihyoProcessParameter implements IBatchProcessParameter {

    private FlexibleYear choteiNendo;
    private RString choteiKijunNichiji;
    private RString kakutukiShikakuKijunNichi;
    private boolean ageFlg;
    private RString ageStart;
    private RString ageEnd;
    private FlexibleDate ageKijunNi;
    private boolean seinengappiYMD_Flg;
    private RString seinengappiYMDStart;
    private RString seinengappiYMDEnd;
    private RString sentakuTaisho;
    private List<RString> sentakuKekkaList;
    private RString shichosonCode;
    private RString shichosonMeisho;
    private RString kyuShichosonCode;
    private RString kyuShichosonMeisho;
    private boolean is1と3場合;
    private boolean is2場合;
    private boolean is町域;
    private boolean is行政区;
    private boolean is地区1;
    private boolean is地区2;
    private boolean is地区3;
    private boolean is市町村コード;
    private boolean is市町村と旧市町村;
    private RString 調定年度3月31日;
    private RString 調定年度0401;
    private RString 調定年度0430;
    private RString 調定年度減1;
    private RString 調定年度減2;
    private FlexibleDate 終了生年月日;
    private FlexibleDate 開始生年月日;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタ
     *
     * @param choteiNendo 調定年度
     * @param choteiKijunNichiji 調定基準日時
     * @param kakutukiShikakuKijunNichi 各月資格基準日
     * @param ageFlg 年齢フラグ
     * @param ageStart 年齢開始
     * @param ageEnd 年齢終了
     * @param ageKijunNi 年齢基準日
     * @param seinengappiYMD_Flg 生年月日フラグ
     * @param seinengappiYMDStart 生年月日開始
     * @param seinengappiYMDEnd 生年月日終了
     * @param sentakuTaisho 選択対象
     * @param sentakuKekkaList List<SentakuKekka>
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村名称
     * @param kyuShichosonCode 旧市町村コード
     * @param kyuShichosonMeisho 旧市町村名称
     */
    public CreateTsukibetsuSuiihyoProcessParameter(
            FlexibleYear choteiNendo,
            RString choteiKijunNichiji,
            RString kakutukiShikakuKijunNichi,
            boolean ageFlg,
            RString ageStart,
            RString ageEnd,
            FlexibleDate ageKijunNi,
            boolean seinengappiYMD_Flg,
            RString seinengappiYMDStart,
            RString seinengappiYMDEnd,
            RString sentakuTaisho,
            List<RString> sentakuKekkaList,
            RString shichosonCode,
            RString shichosonMeisho,
            RString kyuShichosonCode,
            RString kyuShichosonMeisho) {
        this.choteiNendo = choteiNendo;
        this.choteiKijunNichiji = choteiKijunNichiji;
        this.kakutukiShikakuKijunNichi = kakutukiShikakuKijunNichi;
        this.ageFlg = ageFlg;
        this.ageStart = ageStart;
        this.ageEnd = ageEnd;
        this.ageKijunNi = ageKijunNi;
        this.seinengappiYMD_Flg = seinengappiYMD_Flg;
        this.seinengappiYMDStart = seinengappiYMDStart;
        this.seinengappiYMDEnd = seinengappiYMDEnd;
        this.sentakuTaisho = sentakuTaisho;
        this.sentakuKekkaList = sentakuKekkaList;
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.kyuShichosonCode = kyuShichosonCode;
        this.kyuShichosonMeisho = kyuShichosonMeisho;
    }

    /**
     * 月別推移表作成_バッチ用のMybatisパラメータクラス作成
     *
     * @return 月別推移表作成_バッチ用のMybatisパラメータクラス
     */
    public CreateTsukibetsuSuiihyoMyBatisParameter toCreateTsukibetsuSuiihyoMyBatisParameter() {
        return CreateTsukibetsuSuiihyoMyBatisParameter.create_MyBatisParameter(choteiNendo, choteiKijunNichiji,
                kakutukiShikakuKijunNichi, ageFlg, ageStart, ageEnd, ageKijunNi, seinengappiYMD_Flg, seinengappiYMDStart,
                seinengappiYMDEnd, sentakuTaisho, sentakuKekkaList, shichosonCode, shichosonMeisho, kyuShichosonCode, kyuShichosonMeisho,
                is1と3場合, is2場合, is町域, is行政区, is地区1, is地区2, is地区3, is市町村コード, is市町村と旧市町村, 調定年度3月31日,
                調定年度0401, 調定年度0430, 調定年度減1, 調定年度減2, 終了生年月日, 開始生年月日, false, psmShikibetsuTaisho);
    }

}
