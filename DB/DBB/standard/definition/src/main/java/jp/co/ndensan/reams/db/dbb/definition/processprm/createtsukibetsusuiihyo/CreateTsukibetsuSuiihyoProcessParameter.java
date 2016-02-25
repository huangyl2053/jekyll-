/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 月別推移表作成のバッチ処理クラスのパラメータです。
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
    private RString ageKijunNi;
    private boolean seinengappiYMD_Flg;
    private RString seinengappiYMDStart;
    private RString seinengappiYMDEnd;
    private RString sentakuTaisho;
    private List<RString> sentakuKekkaList;
    private RString shichosonCode;
    private RString shichosonMeisho;
    private RString kyuShichosonCode;
    private RString kyuShichosonMeisho;

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
            RString ageKijunNi,
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

    public CreateTsukibetsuSuiihyoProcessParameter toCreateTsukibetsuSuiihyoMyBatisParameter() {
        return new CreateTsukibetsuSuiihyoProcessParameter(
                choteiNendo,
                choteiKijunNichiji,
                kakutukiShikakuKijunNichi,
                ageFlg,
                ageStart,
                ageEnd,
                ageKijunNi,
                seinengappiYMD_Flg,
                seinengappiYMDStart,
                seinengappiYMDEnd,
                sentakuTaisho,
                sentakuKekkaList,
                shichosonCode,
                shichosonMeisho,
                kyuShichosonCode,
                kyuShichosonMeisho);
    }

}
