/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihenkotsuchihakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokankihonjiho.ShokanKihonJihoEntiy;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 *
 * 支払方法変更管理のMapperクラスです。
 */
public interface IShiharaiHenkoTsuchiHakkoMapper {

    /**
     * 償還払請求情報のselect処理です。
     *
     *
     * @param hihokenshaNo hihokenshaNo
     * @param kanriKubun kanriKubun
     * @param rirekiNo rirekiNo
     * @param johoBunruiKubun johoBunruiKubun
     *
     * @return 償還払請求情報list
     */
    List<ShokanKihonJihoEntiy> selectShokanKihon(@Param("hihokenshaNo") HihokenshaNo hihokenshaNo,
            @Param("kanriKubun") RString kanriKubun,
            @Param("rirekiNo") int rirekiNo,
            @Param("johoBunruiKubun") RString johoBunruiKubun);

}
