/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 月別推移表作成_バッチ用のパラメータです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateTsukibetsuSuiihyoBatchParameter extends BatchParameterBase {

    private static final String KEY_CHOTEINENDO = "choteiNendo";
    private static final String KEY_CHOTEIKIJUNNICHIJI = "choteiKijunNichiji";
    private static final String KEY_KAKUTUKISHIKAKUKIJUNNICHI = "KakutukiShikakuKijunNichi";
    private static final String KEY_AGEFLG = "ageFlg";
    private static final String KEY_AGESTART = "ageStart";
    private static final String KEY_AGEEND = "ageEnd";
    private static final String KEY_AGEKIJUNNI = "ageKijunNi";
    private static final String KEY_SEINENGAPPIYMD_FLG = "seinengappiYMD_Flg";
    private static final String KEY_SEINENGAPPIYMDSTART = "seinengappiYMDStart";
    private static final String KEY_SEINENGAPPIYMDEND = "seinengappiYMDEnd";
    private static final String KEY_SENTAKUTAISHO = "sentakuTaisho";
    private static final String KEY_LIST_SENTAKUKEKKA = "sentakuKekkaList";
    private static final String KEY_SHICHOSONCODE = "shichosonCode";
    private static final String KEY_SHICHOSONMEISHO = "shichosonMeisho";
    private static final String KEY_KYUSHICHOSONCODE = "kyuShichosonCode";
    private static final String KEY_KYUSHICHOSONMEISHO = "kyuShichosonMeisho";

    @BatchParameter(key = KEY_CHOTEINENDO, name = "調定年度")
    private FlexibleYear choteiNendo;
    @BatchParameter(key = KEY_CHOTEIKIJUNNICHIJI, name = "調定基準日時")
    private RString choteiKijunNichiji;
    @BatchParameter(key = KEY_KAKUTUKISHIKAKUKIJUNNICHI, name = "各月資格基準日")
    private RString kakutukiShikakuKijunNichi;
    @BatchParameter(key = KEY_AGEFLG, name = "年齢フラグ")
    private boolean ageFlg;
    @BatchParameter(key = KEY_AGESTART, name = "年齢開始")
    private RString ageStart;
    @BatchParameter(key = KEY_AGEEND, name = "年齢終了")
    private RString ageEnd;
    @BatchParameter(key = KEY_AGEKIJUNNI, name = "年齢基準日")
    private RString ageKijunNi;
    @BatchParameter(key = KEY_SEINENGAPPIYMD_FLG, name = "生年月日フラグ")
    private boolean seinengappiYMD_Flg;
    @BatchParameter(key = KEY_SEINENGAPPIYMDSTART, name = "生年月日開始")
    private RString seinengappiYMDStart;
    @BatchParameter(key = KEY_SEINENGAPPIYMDEND, name = "生年月日終了")
    private RString seinengappiYMDEnd;
    @BatchParameter(key = KEY_SENTAKUTAISHO, name = "選択対象")
    private RString sentakuTaisho;
    @BatchParameter(key = KEY_LIST_SENTAKUKEKKA, name = "List<SentakuKekka>")
    private List<RString> sentakuKekkaList;
    @BatchParameter(key = KEY_SHICHOSONCODE, name = "市町村コード")
    private RString shichosonCode;
    @BatchParameter(key = KEY_SHICHOSONMEISHO, name = "市町村名称")
    private RString shichosonMeisho;
    @BatchParameter(key = KEY_KYUSHICHOSONCODE, name = "旧市町村コード")
    private RString kyuShichosonCode;
    @BatchParameter(key = KEY_KYUSHICHOSONMEISHO, name = "旧市町村名称")
    private RString kyuShichosonMeisho;

    /**
     * 月別推移表作成_バッチ用のパラメータ作成
     *
     * @return 月別推移表作成_バッチ用のパラメータ
     */
    public CreateTsukibetsuSuiihyoProcessParameter toCreateTsukibetsuSuiihyoProcessParameter() {
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
