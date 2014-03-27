/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.UDT022CodeTable;

/**
 * 一次判定警告についてマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiKeikokuMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private IchijiHanteiKeikokuMapper() {
    }

    /**
     * 一次判定結果Entityが持つ警告配列コードと一次判定年月日の情報を元に、一次判定警告Listを生成して返します。
     *
     * @param entity 一次判定結果Entity
     * @return 一次判定警告List
     */
    public static IchijiHanteiKeikokuList to一次判定警告List(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        //TODO n8178 城間篤人 対応するコードマスタが用意された後、コメントアウトをはずす 2014年3月
//        RString 警告配列コード = entity.getIchijiHnateiKeikokuCode();
//        IchijiHanteiKeikokuShubetsu 警告種別 = IchijiHanteiKeikokuShubetsu.toValue(entity.getIchijiHanteiYMD());
//        List<UDT022CodeTable> コードマスタ内一次判定警告List = CodeMaster.getCode(警告種別.get警告種別コード(), true);
//
//        List<IchijiHanteiKeikoku> 一次判定警告List = new ArrayList<>();
//        for (int i = 0; i < 警告配列コード.length(); i++) {
//            if (警告配列コード.stringAt(i).equals(new RString("1"))) {
//                一次判定警告List.add(to一次判定警告(コードマスタ内一次判定警告List.get(i)));
//            }
//        }
//
//        return new IchijiHanteiKeikokuList(警告配列コード, 警告種別, 一次判定警告List);
        return new IchijiHanteiKeikokuList(new RString("001101"), IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版, Collections.EMPTY_LIST);
    }

    private static IchijiHanteiKeikoku to一次判定警告(UDT022CodeTable コードマスタ内一次判定警告) {
        return new IchijiHanteiKeikoku(コードマスタ内一次判定警告.getコード(),
                コードマスタ内一次判定警告.getコード名称(), コードマスタ内一次判定警告.getコード略称());
    }
}
