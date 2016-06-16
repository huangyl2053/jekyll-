/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.mapper;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteikeikoku.IchijiHanteiKeikokuHairetsuCode;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteikeikoku.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.definition.core.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
     * @param 警告配列コード IchijiHanteiKeikokuHairetsuCode
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

        RString 警告コード = RString.EMPTY.padZeroToLeft(IchijiHanteiKeikokuShubetsu.介護保険制度2009年度版.get警告数());
        return new IchijiHanteiKeikokuList(
                new IchijiHanteiKeikokuHairetsuCode(警告コード, new FlexibleDate("20090401")),
                Collections.EMPTY_LIST);
    }

//    private static IchijiHanteiKeikoku to一次判定警告(UDT022CodeTable コードマスタ内一次判定警告) {
//        return new IchijiHanteiKeikoku(コードマスタ内一次判定警告.getコード(),
//                コードマスタ内一次判定警告.getコード名称(), コードマスタ内一次判定警告.getコード略称());
//    }
}
