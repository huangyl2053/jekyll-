/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.JuminJohoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 住所地特例などで、異動対象者の名寄せに使用する住民情報です。
 *
 * @author n8178 城間篤人
 */
public class JuminJoho {

    private static final RString BREAK_STRING = new RString(",");
    private static final int SHICHOSON_CODE_INDEX = 2;
    private final JuminJohoModel model;
    private final RString modelStr;

    /**
     * コンストラクタです。
     *
     * @param model 住民情報Model
     */
    public JuminJoho(JuminJohoModel model) throws NullPointerException {
        requireNonNull(model, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("住民情報Model", getClass().getName()));
        this.model = model;
        this.modelStr = createJuminJohoStr();
    }

    private RString createJuminJohoStr() {
        RStringBuilder modelStrBuilder = new RStringBuilder();
        modelStrBuilder.append(model.get識別コード().getColumnValue());
        modelStrBuilder.append(BREAK_STRING);
        modelStrBuilder.append(model.get住民種別().toRString());
        modelStrBuilder.append(BREAK_STRING);
        modelStrBuilder.append(model.getカナ名称().value());
        modelStrBuilder.append(BREAK_STRING);
        modelStrBuilder.append(model.get性別().getName());
        modelStrBuilder.append(BREAK_STRING);
        modelStrBuilder.append(model.get生年月日().toDate().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.NONE).toDateString());
        modelStrBuilder.append(BREAK_STRING);
        modelStrBuilder.append(model.get地区コード3().getColumnValue().substring(SHICHOSON_CODE_INDEX));
        modelStrBuilder.append(BREAK_STRING);
        return modelStrBuilder.toRString();
    }

    /**
     * 住所地特例で使用する、必要な住民情報を連結した文字列を返します。
     *
     * @return 住民情報を連結した文字列
     */
    public RString getJuminJohoString() {
        return modelStr;
    }

    /**
     * 識別対象のListを受け取り、住民情報のListに変換して返します。
     *
     * @param shikibetsuTaishoList 識別対象のList
     * @return 住民情報のList
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    //TODO n8178 城間篤人 識別対象のヒストリを使用できることが確認できたら、ShikibetsuTaishoHistoriesを受け取るように修正したほうがよい 2014/12/24
    public static IItemList<JuminJoho> createListBy(IItemList<IShikibetsuTaisho> shikibetsuTaishoList) throws NullPointerException {
        List<JuminJoho> juminJohoList = new ArrayList<>();
        for (IShikibetsuTaisho shikibetsuTaisho : shikibetsuTaishoList) {
            JuminJohoModel model = new JuminJohoModel(shikibetsuTaisho);
            juminJohoList.add(new JuminJoho(model));
        }
        return ItemList.of(juminJohoList);
    }
}
