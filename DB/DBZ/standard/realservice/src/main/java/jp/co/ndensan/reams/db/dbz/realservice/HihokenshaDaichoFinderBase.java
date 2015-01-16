/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
//import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.IHihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳情報の検索機能を提供するクラスです。<br/>
 * 被保険者台帳の検索機能を他クラスに実装する場合は、メンバとしてこのクラスを持ち、それに処理を移譲するように実装します。
 *
 * @author n8178 城間篤人
 * @param <T>
 * {@link jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.IHihokenshaDaicho IHihokenshaDaicho}を実装したクラス
 */
//public class HihokenshaDaichoFinderBase<T extends IHihokenshaDaicho> {
public class HihokenshaDaichoFinderBase<T extends HihokenshaDaichoModel> {

    private final HihokenshaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoFinderBase() {
        dac = InstanceProvider.create(HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac テスト用MockDac
     */
    HihokenshaDaichoFinderBase(HihokenshaDaichoDac dac) {
        this.dac = dac;
    }

    /**
     * 被保険者台帳のキー項目を指定して、該当する被保険者台帳を1件取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return 被保険者台帳
     */
    public Optional<T> find被保険者台帳(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, YMDHMS 処理日時) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号・処理日時を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。
        //2, EntityをHihokenshaDaichoModelに変換してreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 被保険者番号と市町村コードを指定して、特定の被保険者の台帳情報をListで取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 被保険者台帳List
     */
    public IItemList<T> find被保険者台帳List(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //   Dacから返る検索結果は、IItemListを利用して受け取ってください。
        //2, 検索結果をModelのListにしてreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 識別コードと市町村コードを指定して、特定の被保険者の台帳情報をListで取得します。<br/>
     * 被保険者番号が取得できなかった場合などに利用します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 被保険者番号
     * @return 被保険者台帳List
     */
    public IItemList<T> find被保険者台帳List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・識別コードを指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //   Dacから返る検索結果は、IItemListを利用して受け取ってください。
        //2, 取得したEntityListから、識別コードに紐付く最新のEntityを取得します。
        //3, 最新のEntityが持つ被保険者番号を取得します。
        //4, 取得した被保険者番号を元にもう一度検索を行います。
        //      (find被保険者台帳List(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号)を呼び出す。)
        //2, 検索結果をModelのListにしてreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 市町村コード・被保険者番号・資格取得日を指定して、ある資格取得期間中の被保険者台帳情報をListで取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 資格取得日 資格取得日
     * @return ある資格取得期間中の被保険者台帳List
     */
    public IItemList<T> find被保険者台帳List(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, FlexibleDate 資格取得日) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号・資格取得日を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //   Dacから返る検索結果は、IItemListを利用して受け取ってください。
        //2, 検索結果をModelのListにしてreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 被保険者番号を指定して、該当する最新の被保険者台帳を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 被保険者台帳
     */
    public Optional<HihokenshaDaichoModel> find最新被保険者台帳(HihokenshaNo 被保険者番号) {
        return dac.select最新被保険者台帳(被保険者番号);
    }

}
