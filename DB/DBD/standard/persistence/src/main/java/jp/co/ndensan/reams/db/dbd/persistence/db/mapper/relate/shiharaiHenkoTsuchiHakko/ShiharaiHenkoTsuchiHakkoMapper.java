/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaiHenkoTsuchiHakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ShokanKihonJiho.ShokanKihonJihoEntiy;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 *
 * 支払方法変更管理のMapperクラスです。
 */
public interface ShiharaiHenkoTsuchiHakkoMapper {

    /**
     * 支払方法変更のUPDATE処理です。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     * @param kanriKubun
     * @param rirekiNo
     * @param yokokuTsuchiHakkoYMD
     *
     */
    void updateYokokuTsuchiHakkoYMD(@Param("shoKisaiHokenshaNo") ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            @Param("hihokenshaNo") HihokenshaNo hihokenshaNo,
            @Param("kanriKubun") RString kanriKubun,
            @Param("rirekiNo") int rirekiNo,
            @Param("yokokuTsuchiHakkoYMD") FlexibleDate yokokuTsuchiHakkoYMD);

    /**
     * 支払方法変更のUPDATE処理です。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     * @param kanriKubun
     * @param rirekiNo
     * @param shokanTsuchiHakkoYMD
     *
     */
    void updateShokanTsuchiHakkoYMD(@Param("shoKisaiHokenshaNo") ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            @Param("hihokenshaNo") HihokenshaNo hihokenshaNo,
            @Param("kanriKubun") RString kanriKubun,
            @Param("rirekiNo") int rirekiNo,
            @Param("shokanTsuchiHakkoYMD") FlexibleDate shokanTsuchiHakkoYMD);

    /**
     * 支払方法変更差止のUPDATE処理です。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     * @param kanriKubun
     * @param rirekiNo
     * @param johoBunruiKubun
     * @param renNo
     * @param sashitomeTsuchiHakkoYMD
     *
     */
    void updateSashitomeTsuchiHakkoYMD(@Param("shoKisaiHokenshaNo") ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            @Param("hihokenshaNo") HihokenshaNo hihokenshaNo,
            @Param("kanriKubun") RString kanriKubun,
            @Param("rirekiNo") int rirekiNo,
            @Param("johoBunruiKubun") RString johoBunruiKubun,
            @Param("renNo") int renNo,
            @Param("sashitomeTsuchiHakkoYMD") FlexibleDate sashitomeTsuchiHakkoYMD);

    /**
     * 支払方法変更差止のUPDATE処理です。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     * @param kanriKubun
     * @param rirekiNo
     * @param johoBunruiKubun
     * @param renNo
     * @param KojoTsuchiHakkoYMD
     *
     */
    void updateKojoTsuchiHakkoYMD(@Param("shoKisaiHokenshaNo") ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            @Param("hihokenshaNo") HihokenshaNo hihokenshaNo,
            @Param("kanriKubun") RString kanriKubun,
            @Param("rirekiNo") int rirekiNo,
            @Param("johoBunruiKubun") RString johoBunruiKubun,
            @Param("renNo") int renNo,
            @Param("KojoTsuchiHakkoYMD") FlexibleDate KojoTsuchiHakkoYMD);

    /**
     * 支払方法変更のUPDATE処理です。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     * @param kanriKubun
     * @param rirekiNo
     * @param gemmenTsuchiHakkoYMD
     *
     */
    void updateGemmen_TsuchiHakkoYMD(@Param("shoKisaiHokenshaNo") ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            @Param("hihokenshaNo") HihokenshaNo hihokenshaNo,
            @Param("kanriKubun") RString kanriKubun,
            @Param("rirekiNo") int rirekiNo,
            @Param("gemmenTsuchiHakkoYMD") FlexibleDate gemmenTsuchiHakkoYMD);

    /**
     * 償還払請求情報のselect処理です。
     *
     *
     * @param hihokenshaNo
     * @param kanriKubun
     * @param rirekiNo
     * @param johoBunruiKubun
     *
     * @return 償還払請求情報list
     */
    List<ShokanKihonJihoEntiy> selectShokanKihon(@Param("hihokenshaNo") HihokenshaNo hihokenshaNo,
            @Param("kanriKubun") RString kanriKubun,
            @Param("rirekiNo") int rirekiNo,
            @Param("johoBunruiKubun") RString johoBunruiKubun);

}
