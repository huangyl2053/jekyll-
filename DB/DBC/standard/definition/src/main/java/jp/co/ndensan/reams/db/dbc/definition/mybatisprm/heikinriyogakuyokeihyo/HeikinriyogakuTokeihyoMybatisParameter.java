/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.heikinriyogakuyokeihyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 平均利用額統計表作成のMybatisParameterです。
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HeikinriyogakuTokeihyoMybatisParameter implements IMyBatisParameter {

    private final RString taishoNendoYM;
    private final RString kaishiYM;
    private final RString shuryoYM;
    private final RString chikuShitei;
    private final List<RString> selectorChikulist;
    private final RString shichosonCode;
    private final RString shichosonMei;
    private final RString kyuShichosonCode;
    private final RString kyuShichosonMei;
    private final RString donyuKeitaiCode;
    private final boolean istaishoNendoYM;
    private final boolean isshichosonkyuShichosonCode1;
    private final boolean isshichosonkyuShichosonCode2;
    private final boolean isshichosonkyuShichosonCode3;
    private final boolean is町域;
    private final boolean is行政区;
    private final boolean is地区1;
    private final boolean is地区2;
    private final boolean is地区3;

    /**
     * コンストラクタです。
     *
     * @param taishoNendoYM 対象年月
     * @param kaishiYM 開始年月
     * @param shuryoYM 終了年月
     * @param chikuShitei 地区指定
     * @param selectorChikulist 選択地区リス
     * @param shichosonCode 市町村コード
     * @param shichosonMei 市町村名称
     * @param kyuShichosonCode 旧市町村コード
     * @param kyuShichosonMei 旧市町村名称
     * @param donyuKeitaiCode 導入形態コード
     * @param istaishoNendoYM istaishoNendoYM
     * @param isshichosonkyuShichosonCode1 isshichosonkyuShichosonCode1
     * @param isshichosonkyuShichosonCode2 isshichosonkyuShichosonCode2
     * @param isshichosonkyuShichosonCode3 isshichosonkyuShichosonCode3
     * @param is町域 is町域
     * @param is行政区 is行政区
     * @param is地区1 is地区1
     * @param is地区2 is地区2
     * @param is地区3 is地区3
     */
    public HeikinriyogakuTokeihyoMybatisParameter(RString taishoNendoYM,
            RString kaishiYM,
            RString shuryoYM,
            RString chikuShitei,
            List<RString> selectorChikulist,
            RString shichosonCode,
            RString shichosonMei,
            RString kyuShichosonCode,
            RString kyuShichosonMei,
            RString donyuKeitaiCode,
            boolean istaishoNendoYM,
            boolean isshichosonkyuShichosonCode1,
            boolean isshichosonkyuShichosonCode2,
            boolean isshichosonkyuShichosonCode3,
            boolean is町域,
            boolean is行政区,
            boolean is地区1,
            boolean is地区2,
            boolean is地区3) {
        this.taishoNendoYM = taishoNendoYM;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.chikuShitei = chikuShitei;
        this.selectorChikulist = selectorChikulist;
        this.shichosonCode = shichosonCode;
        this.shichosonMei = shichosonMei;
        this.kyuShichosonCode = kyuShichosonCode;
        this.kyuShichosonMei = kyuShichosonMei;
        this.donyuKeitaiCode = donyuKeitaiCode;
        this.istaishoNendoYM = istaishoNendoYM;
        this.isshichosonkyuShichosonCode1 = isshichosonkyuShichosonCode1;
        this.isshichosonkyuShichosonCode2 = isshichosonkyuShichosonCode2;
        this.isshichosonkyuShichosonCode3 = isshichosonkyuShichosonCode3;
        this.is町域 = is町域;
        this.is行政区 = is行政区;
        this.is地区1 = is地区1;
        this.is地区2 = is地区2;
        this.is地区3 = is地区3;
    }
}
