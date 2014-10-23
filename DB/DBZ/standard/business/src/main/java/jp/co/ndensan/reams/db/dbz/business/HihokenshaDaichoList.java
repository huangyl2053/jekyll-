/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.items.ItemList;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者台帳のListを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoList implements Iterable {

    private final IItemList<HihokenshaDaichoModel> hihokenshaDaichoList;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaDaichoList 被保険者台帳List
     */
    public HihokenshaDaichoList(IItemList<HihokenshaDaichoModel> hihokenshaDaichoList) {
        requireNonNull(hihokenshaDaichoList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("引数のList", getClass().getSimpleName()));
        this.hihokenshaDaichoList = hihokenshaDaichoList;
    }

    /**
     * 被保険者台帳Listから、資格得喪情報の表現に必要な要素を抽出して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> to資格得喪List() {
        List<HihokenshaDaichoModel> daichoList = new ArrayList<>();
        //TODO #52997
        //資格得喪を表現するためには、被保険者台帳から、
        //a, 同じ取得日を持つ情報の内、最新のデータ
        //を抽出する必要がある。
        //必要な被保険者台帳情報を、以下の手順で取得する。
        //
        //1, 被保険者台帳の取得日を格納する変数shutokuDateを用意（初期値 = null)。
        //2, 被保険者台帳Listの各要素daichoに対して以下の処理を繰り返し実行し、対象の情報を抽出する。
        //2-1, if !daicho.get取得日().equals(shutokuDate)
        //3, 2-1の判定結果がtrueの場合、以下の処理を実行する。
        //3-1, daichoList.add(daicho)
        //3-2, shutokuDate = daicho.get取得日()
        //4, 抽出した結果を戻り値として返す。
        return ItemList.of(daichoList);
    }

    /**
     * 被保険者台帳Listから、住所地特例情報を表現するために必要な要素を抽出して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> to住所地特例List() {
        List<HihokenshaDaichoModel> daichoList = new ArrayList<>();
        //TODO #52997
        //住所地特例を表現するためには、適用情報と解除情報をそれぞれ取得する必要がある。
        //解除情報を持つ被保険者台帳は、
        //a, 被保険者台帳の解除日にデータを持つもの
        //を抽出することで取得できる。
        //適用情報を持つ被保険者台帳は、
        //b, 被保険者台帳の適用日にデータを持つもの
        //c, 前の適用日から、データが更新されているもの
        //の条件を満たす台帳情報を抽出することで取得できる。
        //
        //必要な被保険者台帳情報を、以下の手順で取得する。
        //
        //1, 被保険者台帳の適用日を格納する変数tekiyoDateを用意（初期値 = null)。
        //2, 被保険者台帳Listの各要素daichoに対して以下の処理を繰り返し実行し、対象の情報を抽出する。
        //2-1, if daicho.get解除日() != null
        //3, 2-1の判定結果がtrueの場合、以下の処理を実行する。
        //3-1, daichoList.add(daicho)
        //3-2, continueで、以降の処理を省略して次のループ処理に移行する。
        //4, 解除情報が取得できなかった場合、以下の判定を行う。
        //4-1, if daicho.get適用日() != null
        //5, 4-1の判定結果がtrueの場合、さらに以下の判定を行う。
        //5-1, if !daicho.get適用日().equals(tekiyoDate)
        //6, 5-1の判定結果がtrueの場合、以下の処理を行う。
        //6-1, daichoList.add(daicho)
        //6-2, tekiyoDate = daicho.get変更日()
        //7, 抽出した結果を戻り値として返す。
        return ItemList.of(daichoList);
    }

    /**
     * 被保険者台帳Listから、資格関連異動情報の表現に必要な要素を抽出して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> to資格関連異動List() {
        List<HihokenshaDaichoModel> daichoList = new ArrayList<>();
        //TODO #52997
        //資格関連異動を表現するためには、被保険者台帳から、
        //a, 被保険者台帳の変更日にデータを持つもの
        //b, 前の変更日から、データが更新されているもの
        //の条件を満たす台帳情報を抽出する必要がある。
        //必要な被保険者台帳情報を、以下の手順で取得する。
        //
        //1, 被保険者台帳の変更日を格納する変数henkoDateを用意（初期値 = null)。
        //2, 被保険者台帳Listの各要素daichoに対して以下の処理を繰り返し実行し、対象の情報を抽出する。
        //2-1, if daicho.get変更日() != null
        //3, 2-1の判定結果がtrueの場合、さらに以下の判定を行う。
        //3-1, if !daicho.get変更日().equals(henkoDate)
        //4, 3-1の判定結果がtrueの場合、以下の処理を行う。
        //4-1, daichoList.add(daicho)
        //4-2, henkoDate = daicho.get変更日()
        //5, 抽出した結果を戻り値として返す。
        return ItemList.of(daichoList);
    }

    public IItemList<HihokenshaDaichoModel> toModelList() {
        List<HihokenshaDaichoModel> modelList = new ArrayList<>();
        //TODO #52997
        //HihokenshaDaichoのtoModelを利用して、HihokenshaDaichoModelのListを作成してください。
        return ItemList.of(modelList);
    }

    @Override
    public Iterator<HihokenshaDaichoModel> iterator() {
        return hihokenshaDaichoList.iterator();
    }

}
