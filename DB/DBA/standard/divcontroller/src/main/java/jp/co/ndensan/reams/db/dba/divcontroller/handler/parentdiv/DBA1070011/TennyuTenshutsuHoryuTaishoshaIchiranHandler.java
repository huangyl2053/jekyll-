package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1070011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha.ITennyuTenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgKoiki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgTennyu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgTenshutsu_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転入転出保留対象者管理Handlerクラスです。
 *
 * @reamsid_L DBA-0470-030 wangxiaodong
 */
public class TennyuTenshutsuHoryuTaishoshaIchiranHandler {

    private final TennyuTenshutsuHoryuTaishoshaIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TennyuTenshutsuHoryuTaishoshaIchiranDiv
     */
    public TennyuTenshutsuHoryuTaishoshaIchiranHandler(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * 転出tplをロードします。
     *
     * @param 転出保留対象者情報 転出保留対象者情報
     */
    public void load_転出情報(List<ITennyuTenshutsuHoryuTaishosha> 転出保留対象者情報) {
        List<dgTenshutsu_Row> list = new ArrayList<>();
        for (ITennyuTenshutsuHoryuTaishosha taishosha : 転出保留対象者情報) {
            dgTenshutsu_Row row = new dgTenshutsu_Row();
            row.getShichosonCode().setValue(taishosha.get市町村コード().value());
            if (taishosha.get被保険者番号() != null) {
                row.getHihokenshaNo().setValue(taishosha.get被保険者番号().value());
            }
            row.getShikibetsuCode().setValue(taishosha.get識別コード().value());
            row.setRirekiNo(new RString(taishosha.get履歴番号()));
            if (taishosha.get宛名氏名() != null) {
                row.setShimei(taishosha.get宛名氏名().value());
            }
            if (taishosha.get宛名カナ氏名() != null) {
                row.setShimeiKana(taishosha.get宛名カナ氏名().value());
            }
            if (taishosha.get性別() != null) {
                row.setSex(taishosha.get性別());
            }
            if (taishosha.get住民種別() != null) {
                row.setJuminShubetsu(taishosha.get住民種別());
            }
            if (taishosha.get生年月日() != null) {
                row.getBirthYMD().setValue(taishosha.get生年月日());
            }
            if (taishosha.get異動年月日() != null) {
                row.getIdoYMD().setValue(taishosha.get異動年月日());
            }
            if (taishosha.get異動事由() != null) {
                row.setIdoJiyu(taishosha.get異動事由());
            }
            if (taishosha.get転出予定住所() != null) {
                row.setTennyuTenshutsuYoteiJusho(taishosha.get転出予定住所().value());
            }
            list.add(row);
        }
        div.getDgTenshutsu().setDataSource(list);
    }

    /**
     * 転入tplをロードします。
     *
     * @param 転入保留対象者情報 転入保留対象者情報
     */
    public void load_転入情報(List<ITennyuTenshutsuHoryuTaishosha> 転入保留対象者情報) {
        List<dgTennyu_Row> list = new ArrayList<>();
        for (ITennyuTenshutsuHoryuTaishosha taishosha : 転入保留対象者情報) {
            dgTennyu_Row row = new dgTennyu_Row();
            row.getShichosonCode().setValue(taishosha.get市町村コード().value());
            if (taishosha.get被保険者番号() != null) {
                row.getHihokenshaNo().setValue(taishosha.get被保険者番号().value());
            }
            row.getShikibetsuCode().setValue(taishosha.get識別コード().value());
            row.setRirekiNo(new RString(taishosha.get履歴番号()));
            if (taishosha.get宛名氏名() != null) {
                row.setShimei(taishosha.get宛名氏名().value());
            }
            if (taishosha.get宛名カナ氏名() != null) {
                row.setShimeiKana(taishosha.get宛名カナ氏名().value());
            }
            if (taishosha.get性別() != null) {
                row.setSex(taishosha.get性別());
            }
            if (taishosha.get住民種別() != null) {
                row.setJuminShubetsu(taishosha.get住民種別());
            }
            if (taishosha.get生年月日() != null) {
                row.getBirthYMD().setValue(taishosha.get生年月日());
            }
            if (taishosha.get異動年月日() != null) {
                row.getIdoYMD().setValue(taishosha.get異動年月日());
            }
            if (taishosha.get異動事由() != null) {
                row.setIdoJiyu(taishosha.get異動事由());
            }
            if (taishosha.get転出予定住所() != null) {
                row.setTennyuTenshutsuYoteiJusho(taishosha.get転出予定住所().value());
            }
            list.add(row);
        }
        div.getDgTennyu().setDataSource(list);
    }

    /**
     * 広域tplをロードします。
     *
     * @param 広域保留対象者情報 広域保留対象者情報
     */
    public void load_広域情報(List<ITennyuTenshutsuHoryuTaishosha> 広域保留対象者情報) {
        List<dgKoiki_Row> list = new ArrayList<>();
        for (ITennyuTenshutsuHoryuTaishosha taishosha : 広域保留対象者情報) {
            dgKoiki_Row row = new dgKoiki_Row();
            row.getShichosonCode().setValue(taishosha.get市町村コード().value());
            if (taishosha.get被保険者番号() != null) {
                row.getHihokennshaNo().setValue(taishosha.get被保険者番号().value());
            }
            row.getShikibetsuCode().setValue(taishosha.get識別コード().value());
            row.setRirekiNo(new RString(taishosha.get履歴番号()));
            if (taishosha.get宛名氏名() != null) {
                row.setShimei(taishosha.get宛名氏名().value());
            }
            if (taishosha.get宛名カナ氏名() != null) {
                row.setShimeiKana(taishosha.get宛名カナ氏名().value());
            }
            if (taishosha.get性別() != null) {
                row.setSex(taishosha.get性別());
            }
            if (taishosha.get住民種別() != null) {
                row.setJuminShubetsu(taishosha.get住民種別());
            }
            if (taishosha.get生年月日() != null) {
                row.getBirthYMD().setValue(taishosha.get生年月日());
            }
            if (taishosha.get異動年月日() != null) {
                row.getIdoYMD().setValue(taishosha.get異動年月日());
            }
            if (taishosha.get異動事由() != null) {
                row.setIdoJiyu(taishosha.get異動事由());
            }
            if (taishosha.get転出予定住所() != null) {
                row.setTenkyoYoteiJusho(taishosha.get転出予定住所().value());
            }
            list.add(row);
        }
        div.getDgKoiki().setDataSource(list);
    }
}
