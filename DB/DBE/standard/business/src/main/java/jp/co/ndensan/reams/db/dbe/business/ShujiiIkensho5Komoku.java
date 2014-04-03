/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.DentatsuNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinchiNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShokujiKoiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TankiKiokuKomoku;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 主治医意見書の詳細情報のうち、一次判定に使用する5項目の情報を扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShujiiIkensho5Komoku {

    private final ShogaiKoreishaJiritsudoKomoku 障害高齢者自立度;
    private final NinchishoKoreishaJiritsudoKomoku 認知症高齢者自立度;
    private final TankiKiokuKomoku 短期記憶;
    private final NinchiNoryokuKomoku 認知能力;
    private final DentatsuNoryokuKomoku 伝達能力;
    private final ShokujiKoiHyokaKomoku 食事行為;

    /**
     * 引数から主治医意見書5項目を受け取り、インスタンスを生成します。
     *
     * @param 障害高齢者自立度 障害高齢者自立度
     * @param 認知症高齢者自立度 認知症高齢者自立度
     * @param 短期記憶 短期記憶
     * @param 認知能力 認知能力
     * @param 伝達能力 伝達能力
     * @param 食事行為 食事行為
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public ShujiiIkensho5Komoku(ShogaiKoreishaJiritsudoKomoku 障害高齢者自立度, NinchishoKoreishaJiritsudoKomoku 認知症高齢者自立度,
            TankiKiokuKomoku 短期記憶, NinchiNoryokuKomoku 認知能力, DentatsuNoryokuKomoku 伝達能力, ShokujiKoiHyokaKomoku 食事行為)
            throws NullPointerException {
        requireNonNull(障害高齢者自立度, Messages.E00003.replace("障害高齢者自立度", getClass().getName()).getMessage());
        requireNonNull(認知症高齢者自立度, Messages.E00003.replace("認知症高齢者自立度", getClass().getName()).getMessage());
        requireNonNull(短期記憶, Messages.E00003.replace("短期記憶", getClass().getName()).getMessage());
        requireNonNull(認知能力, Messages.E00003.replace("認知能力", getClass().getName()).getMessage());
        requireNonNull(伝達能力, Messages.E00003.replace("伝達能力", getClass().getName()).getMessage());
        requireNonNull(食事行為, Messages.E00003.replace("食事行為", getClass().getName()).getMessage());

        this.障害高齢者自立度 = 障害高齢者自立度;
        this.認知症高齢者自立度 = 認知症高齢者自立度;
        this.短期記憶 = 短期記憶;
        this.認知能力 = 認知能力;
        this.伝達能力 = 伝達能力;
        this.食事行為 = 食事行為;
    }

    /**
     * 主治医意見書5項目について、初期値をもったインスタンスを生成します。
     */
    public ShujiiIkensho5Komoku() {
        this.障害高齢者自立度 = new ShogaiKoreishaJiritsudoKomoku(new Code(RString.EMPTY), RString.EMPTY, RString.EMPTY);
        this.認知症高齢者自立度 = new NinchishoKoreishaJiritsudoKomoku(new Code("9"), new RString("記載無し"), new RString("記載無し"));
        this.短期記憶 = TankiKiokuKomoku.記載無し;
        this.認知能力 = NinchiNoryokuKomoku.記載無し;
        this.伝達能力 = DentatsuNoryokuKomoku.記載無し;
        this.食事行為 = ShokujiKoiHyokaKomoku.記載無し;
    }

    /**
     * 障害高齢者自立度を返します。
     *
     * @return 障害高齢者自立度
     */
    public ShogaiKoreishaJiritsudoKomoku get障害高齢者自立度() {
        return 障害高齢者自立度;
    }

    /**
     * 認知症高齢者自立度を返します。
     *
     * @return 認知症高齢者自立度
     */
    public NinchishoKoreishaJiritsudoKomoku get認知症高齢者自立度() {
        return 認知症高齢者自立度;
    }

    /**
     * 短期記憶を返します。
     *
     * @return 短期記憶
     */
    public TankiKiokuKomoku get短期記憶() {
        return 短期記憶;
    }

    /**
     * 認知能力を返します。
     *
     * @return 認知能力
     */
    public NinchiNoryokuKomoku get認知能力() {
        return 認知能力;
    }

    /**
     * 伝達能力を返します。
     *
     * @return 伝達能力
     */
    public DentatsuNoryokuKomoku get伝達能力() {
        return 伝達能力;
    }

    /**
     * 食事行為を返します。
     *
     * @return 食事行為
     */
    public ShokujiKoiHyokaKomoku get食事行為() {
        return 食事行為;
    }

    /**
     * 5項目の回答を元に、一次判定の計算で使用する回答を表す数列を返します。
     *
     * @return 5項目回答
     */
    public RString get5項目回答() {
        RStringBuilder 回答 = new RStringBuilder();
        回答.append(認知症高齢者自立度.getCode().value());
        回答.append(短期記憶.get項目コード());
        回答.append(認知能力.get項目コード());
        回答.append(伝達能力.get項目コード());
        回答.append(食事行為.get項目コード());
        return 回答.toRString();
    }
}
