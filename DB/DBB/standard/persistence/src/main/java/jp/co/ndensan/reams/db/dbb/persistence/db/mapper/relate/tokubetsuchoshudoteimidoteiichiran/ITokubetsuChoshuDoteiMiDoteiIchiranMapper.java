/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokubetsuchoshudoteimidoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuMidoteiIchiranEntity;

/**
 *
 * 特別徴収同定・未同定一覧表作成のバッチフロークラス
 *
 * @reamsid_L DBB-1860-050 pengxingyi
 */
public interface ITokubetsuChoshuDoteiMiDoteiIchiranMapper {

    /**
     * 特別徴収同定一覧情報処理クラスです。
     *
     * @param param {@link TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter}
     * @return {@link List<TokubetsuChoshuDoteiIchiranEntity>}
     */
    List<TokubetsuChoshuDoteiIchiranEntity> get特別徴収同定一覧情報(TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter param);

    /**
     * 特別徴収未同定一覧情報処理クラスです。
     *
     * @param param {@link TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter}
     * @return {@link List<TokubetsuChoshuMidoteiIchiranEntity>}
     */
    List<TokubetsuChoshuMidoteiIchiranEntity> get特別徴収未同定一覧情報(TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter param);
}
