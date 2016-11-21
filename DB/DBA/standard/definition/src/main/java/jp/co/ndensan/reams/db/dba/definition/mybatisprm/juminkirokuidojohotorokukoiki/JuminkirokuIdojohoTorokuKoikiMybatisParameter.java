/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminkirokuidojohotorokukoiki;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 住民異動連携情報登録【広域保険者用】のMybatisParameterのパラメータ。
 *
 * @reamsid_L DBA-1390-010 wanghuafeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JuminkirokuIdojohoTorokuKoikiMybatisParameter implements IMyBatisParameter {

    private final YMDHMS syorinichiji;
    private final List<RString> shichosonCode;
    private static final RString 介護資格 = new RString("DBA");
    private static final RString 年度値 = new RString("0000");
    private final RString サブ業務コード;
    private final RString 処理名;
    private final RString 年度;

    /**
     * パラメータを作成します。
     *
     * @param syorinichiji YMDHMS
     * @param shichosonCode RString
     * @param サブ業務コード RString
     * @param 処理名 RString
     * @param 年度 RString
     */
    private JuminkirokuIdojohoTorokuKoikiMybatisParameter(
            YMDHMS syorinichiji,
            List<RString> shichosonCode,
            RString サブ業務コード,
            RString 処理名,
            RString 年度) {
        this.syorinichiji = syorinichiji;
        this.shichosonCode = shichosonCode;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.年度 = 年度;
    }

    /**
     * パラメータを作成します。
     *
     * @param syorinichiji YMDHMS
     * @param shichosonCode RString
     * @return HanyoListSaishinsaKekkaMybatisParameter
     */
    public static JuminkirokuIdojohoTorokuKoikiMybatisParameter createMybatisParameter(
            YMDHMS syorinichiji,
            List<RString> shichosonCode
    ) {
        RString サブ業務コード = 介護資格;
        RString 処理名 = ShoriName.広域住基連動.get名称();
        RString 年度 = 年度値;
        return new JuminkirokuIdojohoTorokuKoikiMybatisParameter(
                syorinichiji,
                shichosonCode,
                サブ業務コード,
                処理名,
                年度
        );
    }
}
