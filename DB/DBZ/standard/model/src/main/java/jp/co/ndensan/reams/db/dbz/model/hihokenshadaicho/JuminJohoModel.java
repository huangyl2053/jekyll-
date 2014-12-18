/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import java.io.Serializable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static java.util.Objects.requireNonNull;

/**
 * 住所地特例で名寄せの参考情報として使用する、住民情報を表すモデルです。
 *
 * @author n8178 城間篤人
 */
public class JuminJohoModel implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final JuminShubetsu 住民種別;
    private final AtenaKanaMeisho カナ名称;
    private final Gender 性別;
    private final IDateOfBirth 生年月日;
    private final ChikuCode 地区コード3;

    /**
     * コンストラクタです。引数から受け取る識別対象を元に、住所地特例で使用する住民情報インスタンスを生成します。
     *
     * @param shikibetsuTaisho 識別対象
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 個人では無い識別対象が渡されたとき
     */
    public JuminJohoModel(IShikibetsuTaisho shikibetsuTaisho) throws NullPointerException, IllegalArgumentException {
        requireNonNull(shikibetsuTaisho, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("識別対象", getClass().getName()));
        if (!shikibetsuTaisho.canBe個人()) {
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("個人"));
        }

        this.識別コード = shikibetsuTaisho.get識別コード();
        this.住民種別 = shikibetsuTaisho.get住民種別();
        this.カナ名称 = shikibetsuTaisho.get氏名().getKana();
        this.性別 = shikibetsuTaisho.to個人().get性別();
        this.生年月日 = shikibetsuTaisho.to個人().get生年月日();
        //TODO n8178 城間篤人 まだur/developに混ざっていない、地区コードを識別対象の行政区から取得できる修正が完了した後に修正する。 2014/12/24
        this.地区コード3 = new ChikuCode("00999999");
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 住民種別を取得します。
     *
     * @return 住民種別
     */
    public JuminShubetsu get住民種別() {
        return 住民種別;
    }

    /**
     * カナ名称を取得します。
     *
     * @return カナ名称
     */
    public AtenaKanaMeisho getカナ名称() {
        return カナ名称;
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public Gender get性別() {
        return 性別;
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public IDateOfBirth get生年月日() {
        return 生年月日;
    }

    /**
     * 分類3の地区コードを返します。
     *
     * @return 地区コード3
     */
    public ChikuCode get地区コード3() {
        return 地区コード3;
    }

}
