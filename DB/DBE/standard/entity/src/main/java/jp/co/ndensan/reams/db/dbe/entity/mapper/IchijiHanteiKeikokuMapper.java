/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuHairetsuCode;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    public static IchijiHanteiKeikokuList to一次判定警告List(IchijiHanteiKeikokuHairetsuCode 警告配列コード) {
        //TODO n8178 城間篤人 対応するコードマスタが用意された後、コメントアウトをはずす 2014年5月
//        List<UDT022CodeTable> コードマスタ内一次判定警告List = CodeMaster.getCode(警告配列コード.get警告種別().get警告種別コード());
//
//        List<IchijiHanteiKeikoku> 一次判定警告List = new ArrayList<>();
//        for (int i = 0; i < 警告配列コード.length(); i++) {
//            if (警告配列コード.valueAt(i).is警告有り()) {
//                一次判定警告List.add(to一次判定警告(コードマスタ内一次判定警告List.get(i)));
//            }
//        }
//
//        return new IchijiHanteiKeikokuList(警告配列コード, 警告種別, 一次判定警告List);

        return new IchijiHanteiKeikokuList(
                new IchijiHanteiKeikokuHairetsuCode(new RString("001101"), new FlexibleDate("20090401")),
                Collections.EMPTY_LIST);
    }

    private static IchijiHanteiKeikoku to一次判定警告(UDT022CodeTable コードマスタ内一次判定警告) {
        return new IchijiHanteiKeikoku(コードマスタ内一次判定警告.getコード(),
                コードマスタ内一次判定警告.getコード名称(), コードマスタ内一次判定警告.getコード略称());
    }
}
