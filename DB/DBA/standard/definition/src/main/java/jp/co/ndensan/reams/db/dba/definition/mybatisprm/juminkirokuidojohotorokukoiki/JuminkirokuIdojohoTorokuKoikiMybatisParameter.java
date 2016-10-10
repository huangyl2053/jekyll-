/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminkirokuidojohotorokukoiki;

import java.util.List;
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
public class JuminkirokuIdojohoTorokuKoikiMybatisParameter implements IMyBatisParameter {

    private final YMDHMS syorinichiji;
    private final List<RString> shichosonCode;

    /**
     * コンストラクタ。
     *
     * @param syorinichiji 処理日時
     * @param shichosonCode RString
     */
    public JuminkirokuIdojohoTorokuKoikiMybatisParameter(
            YMDHMS syorinichiji,
            List<RString> shichosonCode) {
        this.syorinichiji = syorinichiji;
        this.shichosonCode = shichosonCode;
    }
}
