/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.houshold;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold.HousholdParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold.HousholdUpdateParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.houshold.HousholdEntity;

/**
 * 非課税年金対象者情報登録 Mapperです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
public interface IHousholdMapper {

    /**
     * 引数により、非課税年金対象情報を取得します。
     *
     * @param parameter パラメータ
     * @return 申請一覧情報
     */
    List<HousholdEntity> 非課税年金対象情報取得(HousholdParameter parameter);

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「解除キー」と「解除」を参照し、DBに更新します。
     *
     * @param parameter パラメータ
     */
    void 取込_保存処理(HousholdUpdateParameter parameter);

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「解除キー」を参照し、当該データを削除します。
     *
     * @param parameter パラメータ
     */
    void 削除解除_登録区分_画面登録_保存処理(HousholdUpdateParameter parameter);

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(INSERT))」の「新規登録」を参照し、DBに追加します。
     *
     * @param parameter パラメータ
     */
    void 新規_保存処理(HousholdUpdateParameter parameter);

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「更新条件検索キー」と「更新_画面登録」を参照し、DBに更新します。
     *
     * @param parameter パラメータ
     */
    void 修正_登録区分_画面登録_保存処理(HousholdUpdateParameter parameter);

}
