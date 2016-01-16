/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 境界層管理マスタリストのバッチ処理クラスのパラメータ
 */
public class KyokaisoGaitoshaProcessParameter implements IBatchProcessParameter {

    private final RString mode;
    private final RString Range;
    private final FlexibleDate Date_FROM;
    private final FlexibleDate Date_TO;
    private final RString iskyuufugakuGengakuKisaiKiajoFlag;
    private final RString ishyojunFutanGengakuGaitoFlag;
    private final RString iskyojuhinadoFutangakugengakuGaitoFlag;
    private final RString isshokuhiKeigengoHutangakuGaitoFlag;
    private final RString iskogakuServicehiJogengakuGengakuGaitoFlag;
    private final RString ishokenryoNofuGengakuFlag;
    private final RString order_ID;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタ
     *
     * @param mode 取得モード
     * @param Range 境界層対象抽出範囲
     * @param Date_FROM 日付FROM
     * @param Date_TO 日付TO
     * @param iskyuufugakuGengakuKisaiKiajoFlag
     * @param ishyojunFutanGengakuGaitoFlag
     * @param iskyojuhinadoFutangakugengakuGaitoFlag
     * @param isshokuhiKeigengoHutangakuGaitoFlag
     * @param iskogakuServicehiJogengakuGengakuGaitoFlag
     * @param ishokenryoNofuGengakuFlag
     * @param order_ID 出力順ID
     */
    public KyokaisoGaitoshaProcessParameter(RString mode,
            RString Range,
            FlexibleDate Date_FROM,
            FlexibleDate Date_TO,
            RString iskyuufugakuGengakuKisaiKiajoFlag,
            RString ishyojunFutanGengakuGaitoFlag,
            RString iskyojuhinadoFutangakugengakuGaitoFlag,
            RString isshokuhiKeigengoHutangakuGaitoFlag,
            RString iskogakuServicehiJogengakuGengakuGaitoFlag,
            RString ishokenryoNofuGengakuFlag,
            RString order_ID) {
        this.Date_FROM = Date_FROM;
        this.Date_TO = Date_TO;
        this.iskyuufugakuGengakuKisaiKiajoFlag = iskyuufugakuGengakuKisaiKiajoFlag;
        this.Range = Range;
        this.ishyojunFutanGengakuGaitoFlag = ishyojunFutanGengakuGaitoFlag;
        this.iskyojuhinadoFutangakugengakuGaitoFlag = iskyojuhinadoFutangakugengakuGaitoFlag;
        this.isshokuhiKeigengoHutangakuGaitoFlag = isshokuhiKeigengoHutangakuGaitoFlag;
        this.iskogakuServicehiJogengakuGengakuGaitoFlag = iskogakuServicehiJogengakuGengakuGaitoFlag;
        this.mode = mode;
        this.order_ID = order_ID;
        this.ishokenryoNofuGengakuFlag = ishokenryoNofuGengakuFlag;
        //this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public KyokaisoGaitoshaMybatisParameter toKyokaisoGaitoshaMybatisParameter() {
        return new KyokaisoGaitoshaMybatisParameter(mode,
                Range,
                Date_FROM,
                Date_TO,
                iskyuufugakuGengakuKisaiKiajoFlag,
                ishyojunFutanGengakuGaitoFlag,
                iskyojuhinadoFutangakugengakuGaitoFlag,
                isshokuhiKeigengoHutangakuGaitoFlag,
                iskogakuServicehiJogengakuGengakuGaitoFlag,
                ishokenryoNofuGengakuFlag,
                order_ID,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                psmShikibetsuTaisho);
    }
}
