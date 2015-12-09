package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shisetsuJohoCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shisetujyoho.KaigoJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.shisetujyoho.KaigoJogaiTokureiTaishoShisetsuInputGuide;
import jp.co.ndensan.reams.db.dba.service.core.shisetsu.ShisetsuJohoInputGuideFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 施設情報DivのHandlerクラスです。
 */
public class ShisetsuJohoHandler {

    private final shisetsuJohoCommonChildDivDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 事業者種類共有子Divのエンティティ
     */
    public ShisetsuJohoHandler(shisetsuJohoCommonChildDivDiv div) {
	this.div = div;
    }

    /**
     * 施設情報に初期化を設定する。
     *
     * @param 台帳種別表示 RString
     * @param 台帳種別 RString
     */
    public void load(RString 台帳種別表示, RString 台帳種別) {

	if (台帳種別表示.equals(new RString("0"))) {

	    div.getDdlDaichoShubetsu().setDataSource(ドロップダウンの設定());
	    div.getDdlDaichoShubetsu().setSelectedKey(DaichoType.被保険者.getCode());
	    div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
	}

	if (台帳種別表示.equals(new RString("1")) && !DaichoType.被保険者.getCode().equals(台帳種別)
		&& !DaichoType.他市町村住所地特例者.getCode().equals(台帳種別) && !DaichoType.適用除外者.getCode().equals(台帳種別)) {

	    div.getRadKaigoHokenShisetsu().setVisible(true);
	    div.getRadOtherTokureiShisetsu().setVisible(true);
	    div.getRadTekiyoJyogaiShisetsu().setVisible(true);
	    div.getDdlDaichoShubetsu().setVisible(false);
	    div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
	}

	if (台帳種別表示.equals(new RString("1")) && (DaichoType.被保険者.getCode().equals(台帳種別)
		|| DaichoType.他市町村住所地特例者.getCode().equals(台帳種別) || DaichoType.適用除外者.getCode().equals(台帳種別))) {
	    if (台帳種別.equals(DaichoType.被保険者.getCode())) {
		div.getRadTekiyoJyogaiShisetsu().setVisible(false);
		div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
		div.getDdlDaichoShubetsu().setVisible(false);
	    }

	    if (台帳種別.equals(DaichoType.他市町村住所地特例者.getCode())) {

		div.getRadTekiyoJyogaiShisetsu().setVisible(false);
		div.getDdlDaichoShubetsu().setVisible(false);
		div.getRadOtherTokureiShisetsu().setSelectedKey(ShisetsuType.住所地特例対象施設.getCode());
	    }
	    if (台帳種別.equals(DaichoType.適用除外者.getCode())) {

		div.getRadKaigoHokenShisetsu().setVisible(false);
		div.getRadOtherTokureiShisetsu().setVisible(false);
		div.getRadTekiyoJyogaiShisetsu().setVisible(false);
		div.getDdlDaichoShubetsu().setVisible(false);
	    }
	}
    }

    /**
     * 台帳種別を設定する。
     *
     * @param 台帳種別表示 RString
     */
    public void onChange(RString 台帳種別表示) {
	if (台帳種別表示.equals(new RString("0"))) {

	    if (DaichoType.被保険者.getCode().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
		div.getRadKaigoHokenShisetsu().setVisible(true);
		div.getRadOtherTokureiShisetsu().setVisible(true);
		div.getRadTekiyoJyogaiShisetsu().setVisible(false);
		div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
	    }

	    if (DaichoType.他市町村住所地特例者.getCode().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
		div.getRadKaigoHokenShisetsu().setVisible(true);
		div.getRadOtherTokureiShisetsu().setVisible(true);
		div.getRadTekiyoJyogaiShisetsu().setVisible(false);
		div.getRadOtherTokureiShisetsu().setSelectedKey(ShisetsuType.住所地特例対象施設.getCode());
	    }

	    if (DaichoType.適用除外者.getCode().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
		div.getRadKaigoHokenShisetsu().setVisible(false);
		div.getRadOtherTokureiShisetsu().setVisible(false);
		div.getRadTekiyoJyogaiShisetsu().setVisible(false);
		div.getRadTekiyoJyogaiShisetsu().setSelectedKey(ShisetsuType.適用除外施設.getCode());
	    }
	}
    }

    /**
     * 入所施設名称の取得。
     *
     * @param 台帳種別
     * @param 台帳種別表示
     */
    public void selectShiSeTuMeiSyo(RString 台帳種別, RString 台帳種別表示) {

	if ((台帳種別表示.equals(new RString("0")) && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
		&& !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
		&& !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && 台帳種別.equals(DaichoType.被保険者.getCode())
		&& div.getRadKaigoHokenShisetsu().getSelectedKey() != null && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && 台帳種別.equals(DaichoType.他市町村住所地特例者.getCode())
		&& div.getRadKaigoHokenShisetsu().getSelectedKey() != null && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())) {

	    ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
	    List<KaigoJigyoshaInputGuide> kaigoJigyosha = shisetsuJoho.getKaigoJigyoshaInputGuide(new KaigoJigyoshaNo(div.getTxtNyuryokuShisetsuKodo().getValue()), FlexibleDate.getNowDate());
	    if (kaigoJigyosha != null && !kaigoJigyosha.isEmpty()) {
		div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJigyosha.get(0).get事業者名称().value());
		div.getTxtNyuryokuShisetsuKodo().setValue(kaigoJigyosha.get(0).get事業者番号().value());
	    } else {

		div.getTxtNyuryokuShisetsuMeisho().clearValue();
	    }
	}

	if ((台帳種別表示.equals(new RString("0")) && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
		&& !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
		&& !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && 台帳種別.equals(DaichoType.被保険者.getCode())
		&& div.getRadOtherTokureiShisetsu().getSelectedKey() != null && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && 台帳種別.equals(DaichoType.他市町村住所地特例者.getCode())
		&& div.getRadOtherTokureiShisetsu().getSelectedKey() != null && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())) {

	    ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
	    List<KaigoJogaiTokureiTaishoShisetsuInputGuide> kaigoJogaiTokureiTaishoShisetsu = shisetsuJoho.
		    getKaigoJogaiTokureiTaishoShisetsuInputGuide(ShisetsuType.住所地特例対象施設.getCode(), new JigyoshaNo(div.getTxtNyuryokuShisetsuKodo().getValue()), FlexibleDate.getNowDate());
	    div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJogaiTokureiTaishoShisetsu.get(0).get事業者名称().value());
	}

	if ((台帳種別表示.equals(new RString("0")) && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
		&& !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
		&& !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
		|| (台帳種別表示.equals(new RString("1")) && 台帳種別.equals(DaichoType.適用除外者.getCode())
		&& (div.getRadTekiyoJyogaiShisetsu().getSelectedKey() == null
		|| div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
		&& (div.getRadOtherTokureiShisetsu().getSelectedKey() == null
		|| div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
		&& (div.getRadKaigoHokenShisetsu().getSelectedKey() == null
		|| div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty()))) {

	    ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
	    List<KaigoJigyoshaInputGuide> kaigoJigyosha = shisetsuJoho.getKaigoJigyoshaInputGuide(new KaigoJigyoshaNo(div.getTxtNyuryokuShisetsuKodo().getValue()), FlexibleDate.getNowDate());
	    div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJigyosha.get(0).get事業者名称().value());
	}

    }

    private List<KeyValueDataSource> ドロップダウンの設定() {

	List<KeyValueDataSource> dataSource = new ArrayList();

	KeyValueDataSource 被保険者 = new KeyValueDataSource();
	被保険者.setKey(DaichoType.被保険者.getCode());
	被保険者.setValue(DaichoType.被保険者.getName());
	dataSource.add(被保険者);

	KeyValueDataSource 他市町村住所地特例者 = new KeyValueDataSource();
	他市町村住所地特例者.setKey(DaichoType.他市町村住所地特例者.getCode());
	他市町村住所地特例者.setValue(DaichoType.他市町村住所地特例者.getName());
	dataSource.add(他市町村住所地特例者);

	KeyValueDataSource 適用除外者 = new KeyValueDataSource();
	適用除外者.setKey(DaichoType.適用除外者.getCode());
	適用除外者.setValue(DaichoType.適用除外者.getName());
	dataSource.add(適用除外者);
	return dataSource;
    }
}
