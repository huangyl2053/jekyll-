/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteitaisyosyaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteitaisyosyaichiran.YokaigoNinteiTaisyosyaIchiranEntity;

/**
 * 要介護認定処理対象者一覧画面のMapperです。
 *
 * @reamsid_L DBD-1531-010 chenxin
 */
public interface IYokaigoNinteiTaisyosyaIchiranMapper {

    /**
     * 広域タイプを取得する。
     *
     * @return List<YokaigoNinteiTaisyosyaIchiranEntity>
     */
    List<YokaigoNinteiTaisyosyaIchiranEntity> get広域タイプ();

    /**
     * 単独タイプを取得する。
     *
     * @return List<YokaigoNinteiTaisyosyaIchiranEntity>
     */
    List<YokaigoNinteiTaisyosyaIchiranEntity> get単独タイプ();
}
