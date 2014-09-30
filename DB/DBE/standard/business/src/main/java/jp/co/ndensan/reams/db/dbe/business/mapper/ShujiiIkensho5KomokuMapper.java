/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinchishoKoreishaJiritsudoKomoku;
import jp.co.ndensan.reams.db.dbe.business.ShogaiKoreishaJiritsudoKomoku;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkensho5Komoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.DentatsuNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinchiNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShokujiKoiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TankiKiokuKomoku;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;

/**
 * 主治医意見書詳細情報のうち、主治医意見書5項目の情報を一次判定処理で利用できる形にマッピングするクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShujiiIkensho5KomokuMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShujiiIkensho5KomokuMapper() {
    }

    /**
     * 主治医意見書詳細情報Entityから、一次判定で使用する形に、必要な項目をマッピングします。<br/>
     * 引数にnullが渡された場合はnullが返ります。
     *
     * @param entity 主治医意見書詳細情報Entity
     * @return 主治医意見書5項目
     */
    public static ShujiiIkensho5Komoku to主治医意見書5項目(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ShujiiIkensho5Komoku(
                create障害高齢者自立度(entity),
                create認知症高齢者自立度(entity),
                TankiKiokuKomoku.toValue(entity.getIk_chukakuShojoTankiKioku()),
                NinchiNoryokuKomoku.toValue(entity.getIk_chukakuShojoNinchiNoryoku()),
                DentatsuNoryokuKomoku.toValue(entity.getIk_chukakuShojoDentatsuNoryoku()),
                ShokujiKoiHyokaKomoku.toValue(entity.getIk_shokuseikatsuShokujiKoi()));
    }

    private static ShogaiKoreishaJiritsudoKomoku create障害高齢者自立度(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        //TODO n8178 城間篤人 主治医意見書結果記録チケット完了後、確認を行ってEntity再生成後に改めて実装 2014年3月
        return new ShogaiKoreishaJiritsudoKomoku(entity.getIk_seikatsuJiritsudoShyogaiCode(),
                entity.getIk_seikatsuJiritsudoShyogaiCodeMeisho(), entity.getIk_seikatsuJiritsudoShyogaiCodeRyakusho());
    }

    private static NinchishoKoreishaJiritsudoKomoku create認知症高齢者自立度(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        return new NinchishoKoreishaJiritsudoKomoku(entity.getIk_seikatsuJiritsudoNinchshoCode(),
                entity.getIk_seikatsuJiritsudoNinchshoCodeMeisho(), entity.getIk_seikatsuJiritsudoNinchshoCodeRyakusho());
    }
}
