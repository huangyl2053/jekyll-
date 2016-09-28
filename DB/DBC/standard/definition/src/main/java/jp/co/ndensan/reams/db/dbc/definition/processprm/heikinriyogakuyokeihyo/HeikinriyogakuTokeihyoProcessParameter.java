/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.heikinriyogakuyokeihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.heikinriyogakuyokeihyo.HeikinriyogakuTokeihyoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 平均利用額統計表作成のProcessParameterです。
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HeikinriyogakuTokeihyoProcessParameter implements IBatchProcessParameter {

    private static final RString 対象年月1 = new RString("1");
    private static final RString 対象年月2 = new RString("2");
    private static final RString 市町村コード = new RString("000000");
    private static final RString 町域 = new RString("町域");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 地区1 = new RString("地区1");
    private static final RString 地区2 = new RString("地区2");
    private static final RString 地区3 = new RString("地区3");
    private static final RString 全て = new RString("全て");
    private RString taishoNendoYM;
    private RString kaishiYM;
    private RString shuryoYM;
    private RString chikuShitei;
    private List<RString> 選択地区;
    private RString shichosonCode;
    private RString shichosonMei;
    private RString kyuShichosonCode;
    private RString kyuShichosonMei;
    private RString donyuKeitaiCode;
    private boolean istaishoNendoYM;
    private boolean isshichosonkyuShichosonCode1;
    private boolean isshichosonkyuShichosonCode2;
    private boolean isshichosonkyuShichosonCode3;
    private boolean is町域;
    private boolean is行政区;
    private boolean is地区1;
    private boolean is地区2;
    private boolean is地区3;

    /**
     * コンストラクタです。
     *
     * @param taishoNendoYM 対象年月
     * @param kaishiYM 開始年月
     * @param shuryoYM 終了年月
     * @param chikuShitei 地区指定
     * @param 選択地区 選択地区
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
    public HeikinriyogakuTokeihyoProcessParameter(
            RString taishoNendoYM,
            RString kaishiYM,
            RString shuryoYM,
            RString chikuShitei,
            List<RString> 選択地区,
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
            boolean is地区3
    ) {
        this.taishoNendoYM = taishoNendoYM;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.chikuShitei = chikuShitei;
        this.選択地区 = 選択地区;
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

    /**
     * 平均利用額統計表作成processのパラメータを作成します。
     *
     * @return HeikinriyogakuTokeihyoProcessParameter
     */
    public HeikinriyogakuTokeihyoMybatisParameter toHeikinriyogakuTokeihyoMybatisParameter() {
        setIschikuShitei(chikuShitei);
        return new HeikinriyogakuTokeihyoMybatisParameter(
                taishoNendoYM,
                kaishiYM,
                shuryoYM,
                chikuShitei,
                選択地区,
                shichosonCode,
                shichosonMei,
                kyuShichosonCode,
                kyuShichosonMei,
                donyuKeitaiCode,
                setIstaishoNendoYM(taishoNendoYM),
                setIsshichosonkyuShichosonCode1(shichosonCode, kyuShichosonCode),
                setIsshichosonkyuShichosonCode2(kyuShichosonCode),
                setIsshichosonkyuShichosonCode3(shichosonCode, kyuShichosonCode),
                is町域,
                is行政区,
                is地区1,
                is地区2,
                is地区3
        );
    }

    private boolean setIstaishoNendoYM(RString taishoNendoYM) {
        istaishoNendoYM = false;
        if (対象年月1.equals(taishoNendoYM)) {
            istaishoNendoYM = true;
        } else if (対象年月2.equals(taishoNendoYM)) {
            istaishoNendoYM = false;
        }
        return istaishoNendoYM;
    }

    private boolean setIsshichosonkyuShichosonCode1(RString shichosonCode, RString kyuShichosonCode) {
        isshichosonkyuShichosonCode1 = false;
        if ((!shichosonCode.isEmpty() && !市町村コード.equals(shichosonCode) && (!kyuShichosonCode.isEmpty() || !市町村コード.equals(kyuShichosonCode)))) {
            isshichosonkyuShichosonCode1 = true;
        }
        return isshichosonkyuShichosonCode1;
    }

    private boolean setIsshichosonkyuShichosonCode2(RString kyuShichosonCode) {
        isshichosonkyuShichosonCode2 = false;
        if (!kyuShichosonCode.isEmpty() && !市町村コード.equals(kyuShichosonCode)) {
            isshichosonkyuShichosonCode2 = true;
        }
        return isshichosonkyuShichosonCode2;
    }

    private boolean setIsshichosonkyuShichosonCode3(RString shichosonCode, RString kyuShichosonCode) {
        isshichosonkyuShichosonCode3 = false;
        if (kyuShichosonCode.isEmpty() && shichosonCode.isEmpty()) {
            isshichosonkyuShichosonCode3 = true;
        }
        return isshichosonkyuShichosonCode3;
    }

    private void setIschikuShitei(RString chikuShitei) {
        is町域 = false;
        is行政区 = false;
        is地区1 = false;
        is地区2 = false;
        is地区3 = false;
        if (全て.equals(chikuShitei)) {
            is町域 = true;
            is行政区 = true;
            is地区1 = true;
            is地区2 = true;
            is地区3 = true;
        } else if (町域.equals(chikuShitei)) {
            is町域 = true;
        } else if (行政区.equals(chikuShitei)) {
            is行政区 = true;
        } else if (地区1.equals(chikuShitei)) {
            is地区1 = true;
        } else if (地区2.equals(chikuShitei)) {
            is地区2 = true;
        } else if (地区3.equals(chikuShitei)) {
            is地区3 = true;
        } else if (chikuShitei.isNullOrEmpty()) {
            is町域 = false;
            is行政区 = false;
            is地区1 = false;
            is地区2 = false;
            is地区3 = false;
        }
    }
}
