/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JukyushaKihonJohoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者基本情報のバッチ処parameterクラスです。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKihonJohoProcessParameter implements IBatchProcessParameter {

    private RString 提供基本情報中間テーブル名;
    private ShinkiIdoKubun 新規異動区分;
    private RDateTime 対象開始日時;
    private RDateTime 対象終了日時;
    private RString 特定個人情報名コード;
    private List<RString> 特定個人情報名コードList;
    private RString 版番号;

    /**
     * 受給者基本情報のMybatisParameterを設定します。
     *
     * @return KaigoJuminhyoMapperParameter
     */
    public JukyushaKihonJohoMybatisParameter toJukyushaKihonJohoMybatisParameter() {
        JukyushaKihonJohoMybatisParameter parameter = new JukyushaKihonJohoMybatisParameter();
        parameter.setTaishoKaishiTimestamp(対象開始日時);
        parameter.setTaishoShuryoTimestamp(対象終了日時);
        parameter.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        return parameter;
    }

}
