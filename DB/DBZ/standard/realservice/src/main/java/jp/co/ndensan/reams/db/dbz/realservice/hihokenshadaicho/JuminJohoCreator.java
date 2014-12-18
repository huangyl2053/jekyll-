/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.JuminJohoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.ur.urz.business.report.parts.corner.ShikibetsuTaishoCornerFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.Kana;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住所地特例などで使用する、名寄せの参考に使用する住民情報を取得するクラスです。
 *
 * @author n8178 城間篤人
 */
public class JuminJohoCreator {

    private final IShikibetsuTaishoFinder shikibetsuTaishoFinder;
    private final IShikibetsuTaisho shikibetsuTaisho;

    /**
     * コンストラクタです。引数から、検索キー作成の元として使用する識別対象を取得します。
     *
     * @param shikibetsuTaisho 識別対象
     */
    public JuminJohoCreator(IShikibetsuTaisho shikibetsuTaisho) {
        this.shikibetsuTaisho = shikibetsuTaisho;
        shikibetsuTaishoFinder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
    }

    /**
     * 検索に必要な情報以外に、外部から個人Finderを受け取るテスト用コンストラクタです。
     *
     * @param shikibetsuTaisho 識別対象
     * @param kojinFinder 個人Finder
     */
    JuminJohoCreator(IShikibetsuTaisho shikibetsuTaisho, IShikibetsuTaishoFinder shikibetsuTaishoFinder) {
        this.shikibetsuTaishoFinder = shikibetsuTaishoFinder;
        this.shikibetsuTaisho = shikibetsuTaisho;
    }

    /**
     * 引数から受け取った識別対象情報が持つカナ氏名・生年月日・性別により検索を行い、該当する識別対象情報を全て取得します。
     *
     * @return 住民情報ModelList
     */
    public IItemList<JuminJohoModel> findJuminJoho() {
        //TODO n8178 城間篤人 宛名照会SimpleDivから、識別対象の履歴を取得できるため、本処理が必要か確認が必要。 2014/12/24
        return null;
    }

}
