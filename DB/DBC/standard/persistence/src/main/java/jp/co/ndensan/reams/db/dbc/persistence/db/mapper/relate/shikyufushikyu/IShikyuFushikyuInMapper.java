/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shikyufushikyu;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140.ShikyuFushikyuKozaMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140.ShikyuFushikyuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38G1KetteishaIchiranTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuKetteiKozaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuRirikoNoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuTsuchishoIchiranEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給（不支給）決定通知書情報取込のDB方法です。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public interface IShikyuFushikyuInMapper {

    /**
     * 決定者一覧一時TBL.№　と一致する　帳票関連付け番号をもった高額合算支給不支給決定者一時データに、<br>
     * 決定者一覧一時TBLの口座情報を取得します。
     *
     * @return ShikyuFushikyuTsuchishoIchiranEntity
     */
    ShikyuFushikyuTsuchishoIchiranEntity get通知書および一覧情報();

    /**
     * 決定者一覧一時TBL.№　と一致する　帳票関連付け番号をもった高額合算支給不支給決定者一時データがない場合、<br>
     * 該当する決定者一覧一覧一時データを取得します。
     *
     * @return DbWT38G1KetteishaIchiranTempEntity
     */
    DbWT38G1KetteishaIchiranTempEntity get一覧データのみ一覧情報();

    /**
     * 再処理の場合、前回処理時に取り込んだデータを物理削除する。
     *
     * @param parameter ShikyuFushikyuMyBatisParameter
     * @return DbT3074KogakuGassanShikyuFushikyuKetteiEntity
     */
    DbT3074KogakuGassanShikyuFushikyuKetteiEntity get削除予定前回処理データ(ShikyuFushikyuMyBatisParameter parameter);

    /**
     * 国保連から渡された口座情報（高額合算支給不支給決定一時TBLの口座情報）が口座マスタに登録されているか確認する。
     *
     * @param parameter ShikyuFushikyuMyBatisParameter
     * @return ShikyuFushikyuKetteiKozaEntity
     */
    ShikyuFushikyuKetteiKozaEntity get口座登録(ShikyuFushikyuKozaMyBatisParameter parameter);

    /**
     * 業務別主キーが業務別主キーTBLから取得する。
     *
     * @param parameter ShikyuFushikyuMyBatisParameter
     * @return RString
     */
    RString get業務別主キー(ShikyuFushikyuMyBatisParameter parameter);

    /**
     * 最大履歴番号を取得する。
     *
     * @return ShikyuFushikyuRirikoNoEntity
     */
    ShikyuFushikyuRirikoNoEntity get最大履歴番号();

}
